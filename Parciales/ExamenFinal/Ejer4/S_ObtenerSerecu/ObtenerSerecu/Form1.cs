using Newtonsoft.Json;
namespace ObtenerSerecu
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void textBoxCI_TextChanged(object sender, EventArgs e)
        {

        }

        private void buttonGenerar_Click(object sender, EventArgs e)
        {
            string cedula = textBoxCI.Text;

            ServiceReferenceSerecu.WebServiceSoapClient servicio = new ServiceReferenceSerecu.WebServiceSoapClient(new ServiceReferenceSerecu.WebServiceSoapClient.EndpointConfiguration());

            string resultado = "";
            switch (comboBoxSerecu.SelectedIndex)
            {
                case 0:
                    labelResultados.Text = "";
                    resultado = JsonConvert.SerializeObject(servicio.ObtenerDatosAsync(cedula));
                    break;
                case 1:
                    labelResultados.Text = "";
                    resultado = JsonConvert.SerializeObject(servicio.ObtenerCertificadoNacimientoAsync(cedula));
                    break;
            }
            labelResultados.Text = resultado;
        }

        private void comboBoxSerecu_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void labelResultados_Click(object sender, EventArgs e)
        {

        }
    }
}
