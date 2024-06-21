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
    public Persona ObtenerDatos(string _cedula)
    {
        Persona p = new Persona(_cedula);
        return p;
    }

    [WebMethod]
    public CertificadoNacimiento ObtenerCertificadoNacimiento(string _cedula)
    {
        CertificadoNacimiento cn = new CertificadoNacimiento(_cedula);
        return cn;
    }
}

[Serializable]
public class Persona
{
    public string Carnet { get; set; }
    public string Nombres { get; set; }
    public string PrimerApellido { get; set; }
    public string SegundoApellido { get; set; }
    public string FechaNacimiento { get; set; }
    public string Sexo { get; set; }
    public string EstadoCivil { get; set; }

    public Persona() { }
    public Persona(string _CedulaIndentidad)
    {
        Carnet = _CedulaIndentidad;
        Nombres = "Juan Carlos";
        PrimerApellido = "Rodríguez";
        SegundoApellido = "Lopez";
        FechaNacimiento = "18/05/1991";
        Sexo = "Masculino";
        EstadoCivil = "Casado";
    }

    public override string ToString()
    {
        return $"Cédula de Identidad: {Carnet}\nNombres: {Nombres}\nApellidos: {PrimerApellido} {SegundoApellido}\nFecha de Nacimiento: {FechaNacimiento}\nSexo: {Sexo}\nEstado Civil: {EstadoCivil}";
    }
}

[Serializable]
public class CertificadoNacimiento
{
    public string CedulaIdentidadNacimiento { get; set; }
    public string Nombres { get; set; }
    public string PrimerApellido { get; set; }
    public string SegundoApellido { get; set; }
    public string FechaNacimiento { get; set; }
    public string NombrePadre { get; set; }
    public string ApellidosPadre { get; set; }
    public string NombreMadre { get; set; }
    public string ApellidosMadre { get; set; }


    CertificadoNacimiento() { }
    public CertificadoNacimiento(string _CedulaIdentidadNacimiento)
    {
        CedulaIdentidadNacimiento = _CedulaIdentidadNacimiento;
        Nombres = "Juan Carlos";
        PrimerApellido = "Rodríguez";
        SegundoApellido = "Lopez";
        FechaNacimiento = "25/08/1985";
        NombrePadre = "Carlos";
        ApellidosPadre = "Rodríguez Pinto";
        NombreMadre = "María";
        ApellidosMadre = "Lopez Salas";
    }

    public override string ToString()
    {
        return $"Cédula de Nacimiento: {CedulaIdentidadNacimiento}\nNombres: {Nombres} {PrimerApellido} {SegundoApellido}\nFecha de Nacimiento: {FechaNacimiento}\nPadre: {NombrePadre} {ApellidosPadre}\nMadre: {NombreMadre} {ApellidosMadre}";
    }
}

