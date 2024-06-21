using Newtonsoft.Json;
using System.Diagnostics;
using System.Text;
using System.Text;

namespace ConsumirServicios
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void comboBoxServicios_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void buttonConsumir_Click(object sender, EventArgs e)
        {
            string resultado = "";
            switch (comboBoxServicios.SelectedIndex)
            {
                case 0:
                    labelResultado.Text = "";
                    llamadoRest();
                    break;
                case 1:
                    labelResultado.Text = "";
                    LlamadoGraphql();
                    break;
            }
           
        }

        private void labelResultado_Click(object sender, EventArgs e)
        {

        }

        public async void LlamadoGraphql()
        {
            using var httpClient = new HttpClient();
            String query = @"
            {
                wheaters{
                    id
                    fecha
                    temperatura
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
                System.Diagnostics.Debug.WriteLine("GraphQL: ", json);
                var seduca = JsonConvert.DeserializeObject<ClimaResponse>(json);
                foreach (var wheater in seduca.data.wheaters)
                {
                    labelResultado.Text += wheater.ToString();
                }
                
            }
            else
            {
                Debug.WriteLine("Error en la consulta Graphql.");
                Debug.WriteLine($"Status Code: {response.StatusCode}");
                var errorContent = await response.Content.ReadAsStringAsync();
                Debug.WriteLine(errorContent);
            }

        }

        public async void llamadoRest()
        {
            string url = "http://127.0.0.1:8000/api/v1/wheater"; // Reemplaza con tu URL de servicio REST
            String resultado = await GetDataFromApiAsync(url);
            System.Diagnostics.Debug.WriteLine("Rest: ", resultado);
            List<ClimaRest> rest = JsonConvert.DeserializeObject<List<ClimaRest>>(resultado);
            foreach (var wheater in rest)
            {
                labelResultado.Text += wheater.ToString();
            }
        }

        private async Task<string> GetDataFromApiAsync(string url)
        {
            using (HttpClient client = new HttpClient())
            {
                try
                {
                    HttpResponseMessage response = await client.GetAsync(url);
                    if (!response.IsSuccessStatusCode)
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
