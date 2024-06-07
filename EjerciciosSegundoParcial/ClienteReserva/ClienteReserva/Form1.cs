using Newtonsoft.Json;
using GraphQL;
using GraphQL.Client.Http;
using GraphQL.Client.Serializer.Newtonsoft;
using System.Text;
using System.Net.Http;
using System.Diagnostics;


namespace ClienteReserva
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

        private void dateTimePicker1_ValueChanged(object sender, EventArgs e)
        {

        }

        private void datefin_ValueChanged(object sender, EventArgs e)
        {

        }

        private void btncotizar_Click(object sender, EventArgs e)
        {

        }

        private void btnreservar_Click(object sender, EventArgs e)
        {

        }

        private void respuesta_Click(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private async void btnverificar_Click(object sender, EventArgs e)
        {
            using var httpClient = new HttpClient();
            String query = @"
            query {
                cotizacion(fecha: '2023-12-02') {
                    fecha
                    cotizacion
                }
            }";
            var request = new HttpRequestMessage(HttpMethod.Post, "http://localhost:4000/graphql");
            request.Content = new StringContent(query, Encoding.UTF8, "application/json");
            var response = await httpClient.SendAsync(request);
            System.Diagnostics.Debug.WriteLine(response);
            if (response.IsSuccessStatusCode)
            {
                var json = await response.Content.ReadAsStringAsync();
                var bc = JsonConvert.DeserializeObject<bancocentral>(json);

                // Mostrar los datos en el formulario
                respuesta.Text = bc.fecha;
                respuesta.Text = bc.cotizacion;
            }
            else
            {
                Debug.WriteLine("Error: Failed to execute GraphQL request.");
                Debug.WriteLine($"Status Code: {response.StatusCode}");
                // Check response content for error details (if available)
                var errorContent = await response.Content.ReadAsStringAsync();
                Debug.WriteLine(errorContent);
            }

        }


        private void respuesta_TextChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
