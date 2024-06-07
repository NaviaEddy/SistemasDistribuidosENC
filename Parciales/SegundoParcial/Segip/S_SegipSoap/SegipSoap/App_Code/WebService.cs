using Microsoft.SqlServer.Server;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de WebService
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class WebService : System.Web.Services.WebService
{

    public WebService()
    {

        //Elimine la marca de comentario de la línea siguiente si utiliza los componentes diseñados 
        //InitializeComponent(); 
    }

    [WebMethod]
    public Datos ObtenerDatos(string _ci)
    {
        Datos d = new Datos(_ci);
        return d;
    }

    [WebMethod]
    public Boolean VerificarDatos(string _ci, string _Nombres, string _PrimerApellido, string _SegundoApellido)
    {
        Datos d = new Datos(_ci);
        if (d.Nombres == _Nombres && d.PrimerApellido == _PrimerApellido && d.SegundoApellido == _SegundoApellido)
        {
            return true;
        }
        return false;
    }

    [Serializable]
    public class Datos
    {
        public string ci { get; set; }
        public string Nombres { get; set; }
        public string PrimerApellido { get; set; }
        public string SegundoApellido { get; set; }

        public Datos() { }
        public Datos(string _ci)
        {
            ci = _ci;
            Nombres = "juan";
            PrimerApellido = "rodriguez";
            SegundoApellido = "lopez";
        }

        public override string ToString()
        {
            return $"Cédula de Identidad: {ci}\nNombres: {Nombres}\nPrimerApellido: {PrimerApellido}\nSegundoApellido: {SegundoApellido}\n";
        }
    }

}
