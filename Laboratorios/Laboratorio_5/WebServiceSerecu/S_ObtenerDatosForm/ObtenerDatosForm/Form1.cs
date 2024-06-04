using Newtonsoft.Json;

namespace ObtenerDatosForm
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void comboBoxTipoDocumento_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBoxCedula_TextChanged(object sender, EventArgs e)
        {

        }

        private void buttonGenerar_Click(object sender, EventArgs e)
        {
            string cedula = textBoxCedula.Text;
            ServiceReferenceSerecu.WebServiceSerecuSoapClient servicio = new ServiceReferenceSerecu.WebServiceSerecuSoapClient(new ServiceReferenceSerecu.WebServiceSerecuSoapClient.EndpointConfiguration());

            string resultado = "";
            switch(comboBoxTipoDocumento.SelectedIndex)
            {
                case 0:
                    resultado = JsonConvert.SerializeObject(servicio.ObtenerDatos(cedula));
                    break;
                case 1:
                    resultado = JsonConvert.SerializeObject(servicio.ObtenerCertificadoNacimiento(cedula));
                    break;
                case 2:
                    resultado = JsonConvert.SerializeObject(servicio.ObtenerCertificadoMatrimonio(cedula));
                    break;
                case 3:
                    resultado = JsonConvert.SerializeObject(servicio.ObtenerCertificadoDefuncion(cedula));
                    break;
            }
            labelDatosResultados.Text = resultado;
        }
    }
}
