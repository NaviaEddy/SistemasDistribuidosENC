using Microsoft.IdentityModel.Protocols.WsTrust;
using Newtonsoft.Json;
using System.Diagnostics;
using System.Net.Http.Json;
using System.Text;
using System.Text.Json.Serialization;
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
                    id
                    ci
                    apellidos
                    nombres
                    Bachiller
                }
            }";
            var request = new HttpRequestMessage(HttpMethod.Post, "http://localhost:4000/graphql");
            request.Content = new StringContent(query, Encoding.UTF8, "application/json");
            var response = await httpClient.SendAsync(request);
            System.Diagnostics.Debug.WriteLine(response);
            if (response.IsSuccessStatusCode)
            {
                var json = await response.Content.ReadAsStringAsync();
                var seduca = JsonConvert.DeserializeObject<Seduca>(json);
                labelSeduca.Text = seduca.ToString();
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
            string url = "http://127.0.0.1:8000/api/v1/participante/81936561"; // Reemplaza con tu URL de servicio REST
            String resultado = await GetDataFromApiAsync(url);

            labelAcademico.Text = resultado;
            Academico academico = JsonConvert.DeserializeObject<Academico>(labelAcademico.Text);
            labelAcademico.Text = academico.ToString();
        }

        private async Task<string> GetDataFromApiAsync(string url)
        {
            using (HttpClient client = new HttpClient())
            {
                try
                {
                    HttpResponseMessage response = await client.GetAsync(url);
                    response.EnsureSuccessStatusCode();
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
