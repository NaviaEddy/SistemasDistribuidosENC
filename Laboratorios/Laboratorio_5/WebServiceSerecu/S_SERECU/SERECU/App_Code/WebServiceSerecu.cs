using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

/// <summary>
/// Descripción breve de WebServiceSerecu
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// Para permitir que se llame a este servicio web desde un script, usando ASP.NET AJAX, quite la marca de comentario de la línea siguiente. 
// [System.Web.Script.Services.ScriptService]
public class WebServiceSerecu : System.Web.Services.WebService
{

    public WebServiceSerecu()
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

    [WebMethod]
    public CertificadoMatrimonio ObtenerCertificadoMatrimonio(string _cedula)
    {
        CertificadoMatrimonio cm = new CertificadoMatrimonio(_cedula);
        return cm;
    }

    [WebMethod]
    public CertificadoDefuncion ObtenerCertificadoDefuncion(string _cedula)
    {
        CertificadoDefuncion cd = new CertificadoDefuncion(_cedula);
        return cd;
    }
}

[Serializable]
public class Persona
{
    public string CedulaIdentidad { get; set; }
    public string Nombres { get; set; }
    public string PrimerApellido { get; set; }
    public string SegundoApellido { get; set; }
    public string FechaNacimiento { get; set; }
    public string Sexo { get; set; }
    public string EstadoCivil { get; set; }

    public Persona() { }
    public Persona(string _CedulaIndentidad)
    {
        CedulaIdentidad = _CedulaIndentidad;
        Nombres = "Juan Carlos";
        PrimerApellido = "Rodríguez";
        SegundoApellido = "Lopez";
        FechaNacimiento = "18/05/1991";
        Sexo = "Masculino";
        EstadoCivil = "Casado";
    }

    public override string ToString()
    {
        return $"Cédula de Identidad: {CedulaIdentidad}\nNombres: {Nombres}\nApellidos: {PrimerApellido} {SegundoApellido}\nFecha de Nacimiento: {FechaNacimiento}\nSexo: {Sexo}\nEstado Civil: {EstadoCivil}";
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

[Serializable]
public class CertificadoMatrimonio
{
    public string CedulaIndentidadMatrimonio { get; set; }
    public string CedulaIdentidadEsposo { get; set; }
    public string NombresEsposo { get; set; }
    public string PrimerApellidoEsposo { get; set; }
    public string SegundoApellidoEsposo { get; set; }
    public string CedulaIdentidadEsposa { get; set; }
    public string NombresEsposa { get; set; }
    public string PrimerApellidoEsposa { get; set; }
    public string SegundoApellidoEsposa { get; set; }


    CertificadoMatrimonio() { }
    public CertificadoMatrimonio(string _CedulaIndentidadMatrimonio)
    {
        CedulaIndentidadMatrimonio = _CedulaIndentidadMatrimonio;
        CedulaIdentidadEsposo = "2334654";
        NombresEsposo = "Juan Carlos";
        PrimerApellidoEsposo = "Rodríguez";
        SegundoApellidoEsposo = "Lopez";
        CedulaIdentidadEsposa = "3154876";
        NombresEsposa = "Ana María";
        PrimerApellidoEsposa = "Gomez";
        SegundoApellidoEsposa = "Torres";
    }

    public override string ToString()
    {
        return $"Cédula de Matrimonio: {CedulaIndentidadMatrimonio}\nEsposo: {NombresEsposo} {PrimerApellidoEsposo} {SegundoApellidoEsposo}\nCédula Esposo: {CedulaIdentidadEsposo}\nEsposa: {NombresEsposa} {PrimerApellidoEsposa} {SegundoApellidoEsposa}\nCédula Esposa: {CedulaIdentidadEsposa}";
    }
}

[Serializable]
public class CertificadoDefuncion
{
    public string CedulaIdentidadDefuncion { get; set; }
    public string Nombres { get; set; }
    public string PrimerApellido { get; set; }
    public string SegundoApellido { get; set; }
    public string FechaDefuncion { get; set; }
    public string Causa { get; set; }


    CertificadoDefuncion() { }
    public CertificadoDefuncion(string _CedulaIdentidadDefuncion)
    {
        CedulaIdentidadDefuncion = _CedulaIdentidadDefuncion;
        Nombres = "Juan Carlos";
        PrimerApellido = "Rodríguez";
        SegundoApellido = "Lopez";
        FechaDefuncion = "10/02/2000";
        Causa = "Causa natural";
    }

    public override string ToString()
    {
        return $"Cédula de Defunción: {CedulaIdentidadDefuncion}\nNombres: {Nombres} {PrimerApellido} {SegundoApellido}\nFecha de Defunción: {FechaDefuncion}\nCausa: {Causa}";
    }
}



