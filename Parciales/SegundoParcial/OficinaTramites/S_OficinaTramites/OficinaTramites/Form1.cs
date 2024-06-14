using Newtonsoft.Json;
using System.Diagnostics;
using System.Text;
using System.Text.Json;



namespace OficinaTramites
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void buttonVerificarDatos_Click(object sender, EventArgs e)
        {
            labelDatos.Text = "";
            string ci = textBoxCIVerificar.Text;
            string nombres = textBoxNombres.Text;
            string papellido = textBoxPrimerApellido.Text;
            string sapellido = textBoxSegundoApellido.Text;
            ServiceReference1.WebServiceSoapClient servicio = new ServiceReference1.WebServiceSoapClient(new ServiceReference1.WebServiceSoapClient.EndpointConfiguration());
            string resultado = "";

            resultado = JsonConvert.SerializeObject(servicio.VerificarDatosAsync(ci, nombres, papellido, sapellido));
            labelDatos.Text = resultado;
            llamadoSeduca();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            labelDatos.Text = "";
            string ci = textBoxCIObtener.Text;
            ServiceReference1.WebServiceSoapClient servicio = new ServiceReference1.WebServiceSoapClient(new ServiceReference1.WebServiceSoapClient.EndpointConfiguration());
            string resultado = "";

            resultado = JsonConvert.SerializeObject(servicio.ObtenerDatosAsync(ci));
            labelDatos.Text = resultado;
        }

        public async void llamadoSeduca()
        {
            using var httpClient = new HttpClient();
            String query = @"
            {
                qualification(ci: ""76607457"") {
                    nombres
                    Bachiller
                }
            }";
            var jsonPayload = new
            {
                query = query
            };

            var jsonString = JsonConvert.SerializeObject(jsonPayload);
            var request = new HttpRequestMessage(HttpMethod.Post, "http://localhost:4000/graphql");
            request.Content = new StringContent(jsonString, Encoding.UTF8, "application/json");
            var response = await httpClient.SendAsync(request);
            System.Diagnostics.Debug.WriteLine(response);
            if (response.IsSuccessStatusCode)
            {
                var json = await response.Content.ReadAsStringAsync();
                System.Diagnostics.Debug.WriteLine("Seduca: ", json);
                var seduca = JsonConvert.DeserializeObject<SeducaResponse>(json);
                labelSeduca.Text = seduca.data.qualification.ToString();
            }
            else
            {
                Debug.WriteLine("Error en la consulta Graphql.");
                Debug.WriteLine($"Status Code: {response.StatusCode}");
                var errorContent = await response.Content.ReadAsStringAsync();
                Debug.WriteLine(errorContent);
            }

            llamadoAcademico();
        }

        public async void llamadoAcademico()
        {
            string url = "http://127.0.0.1:8000/api/v1/academic/81936561"; // Reemplaza con tu URL de servicio REST
            String resultado = await GetDataFromApiAsync(url);
            System.Diagnostics.Debug.WriteLine("Academico: ", resultado);
            Academico academico = JsonConvert.DeserializeObject<Academico>(resultado);
            labelAcademico.Text = academico.ToString();
        }

        private async Task<string> GetDataFromApiAsync(string url)
        {
            using (HttpClient client = new HttpClient())
            {
                try
                {
                    HttpResponseMessage response = await client.GetAsync(url);
                    if(!response.IsSuccessStatusCode)
                    {
                        return $"Error: {response.StatusCode}";
                    }
                    string responseBody = await response.Content.ReadAsStringAsync();
                    return responseBody;
                }
                catch (HttpRequestException ex)
                {
                    return $"Error: {ex.Message}";
                }
            }
        }
    }
}
