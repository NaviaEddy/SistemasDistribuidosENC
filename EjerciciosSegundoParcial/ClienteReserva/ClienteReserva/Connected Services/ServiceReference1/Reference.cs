﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ServiceReference1
{
    using System.Runtime.Serialization;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Oper", Namespace="http://tempuri.org/")]
    public partial class Oper : object
    {
        
        private System.DateTime inicioField;
        
        private System.DateTime finField;
        
        private System.DateTime fechacotizacionField;
        
        private int idclienteField;
        
        private System.DateTime FechaCompraField;
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true)]
        public System.DateTime inicio
        {
            get
            {
                return this.inicioField;
            }
            set
            {
                this.inicioField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=1)]
        public System.DateTime fin
        {
            get
            {
                return this.finField;
            }
            set
            {
                this.finField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=2)]
        public System.DateTime fechacotizacion
        {
            get
            {
                return this.fechacotizacionField;
            }
            set
            {
                this.fechacotizacionField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=3)]
        public int idcliente
        {
            get
            {
                return this.idclienteField;
            }
            set
            {
                this.idclienteField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute(IsRequired=true, Order=4)]
        public System.DateTime FechaCompra
        {
            get
            {
                return this.FechaCompraField;
            }
            set
            {
                this.FechaCompraField = value;
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServiceReference1.WebServiceSoap")]
    public interface WebServiceSoap
    {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Cotizar", ReplyAction="*")]
        System.Threading.Tasks.Task<ServiceReference1.CotizarResponse> CotizarAsync(ServiceReference1.CotizarRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Reservar", ReplyAction="*")]
        System.Threading.Tasks.Task<ServiceReference1.ReservarResponse> ReservarAsync(ServiceReference1.ReservarRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class CotizarRequest
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="Cotizar", Namespace="http://tempuri.org/", Order=0)]
        public ServiceReference1.CotizarRequestBody Body;
        
        public CotizarRequest()
        {
        }
        
        public CotizarRequest(ServiceReference1.CotizarRequestBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class CotizarRequestBody
    {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public System.DateTime inicio;
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=1)]
        public System.DateTime fin;
        
        public CotizarRequestBody()
        {
        }
        
        public CotizarRequestBody(System.DateTime inicio, System.DateTime fin)
        {
            this.inicio = inicio;
            this.fin = fin;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class CotizarResponse
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="CotizarResponse", Namespace="http://tempuri.org/", Order=0)]
        public ServiceReference1.CotizarResponseBody Body;
        
        public CotizarResponse()
        {
        }
        
        public CotizarResponse(ServiceReference1.CotizarResponseBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class CotizarResponseBody
    {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public ServiceReference1.Oper CotizarResult;
        
        public CotizarResponseBody()
        {
        }
        
        public CotizarResponseBody(ServiceReference1.Oper CotizarResult)
        {
            this.CotizarResult = CotizarResult;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class ReservarRequest
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="Reservar", Namespace="http://tempuri.org/", Order=0)]
        public ServiceReference1.ReservarRequestBody Body;
        
        public ReservarRequest()
        {
        }
        
        public ReservarRequest(ServiceReference1.ReservarRequestBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class ReservarRequestBody
    {
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=0)]
        public System.DateTime inicio;
        
        [System.Runtime.Serialization.DataMemberAttribute(Order=1)]
        public System.DateTime fin;
        
        public ReservarRequestBody()
        {
        }
        
        public ReservarRequestBody(System.DateTime inicio, System.DateTime fin)
        {
            this.inicio = inicio;
            this.fin = fin;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(IsWrapped=false)]
    public partial class ReservarResponse
    {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Name="ReservarResponse", Namespace="http://tempuri.org/", Order=0)]
        public ServiceReference1.ReservarResponseBody Body;
        
        public ReservarResponse()
        {
        }
        
        public ReservarResponse(ServiceReference1.ReservarResponseBody Body)
        {
            this.Body = Body;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.Runtime.Serialization.DataContractAttribute(Namespace="http://tempuri.org/")]
    public partial class ReservarResponseBody
    {
        
        [System.Runtime.Serialization.DataMemberAttribute(EmitDefaultValue=false, Order=0)]
        public ServiceReference1.Oper ReservarResult;
        
        public ReservarResponseBody()
        {
        }
        
        public ReservarResponseBody(ServiceReference1.Oper ReservarResult)
        {
            this.ReservarResult = ReservarResult;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    public interface WebServiceSoapChannel : ServiceReference1.WebServiceSoap, System.ServiceModel.IClientChannel
    {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.Tools.ServiceModel.Svcutil", "2.2.0-preview1.23462.5")]
    public partial class WebServiceSoapClient : System.ServiceModel.ClientBase<ServiceReference1.WebServiceSoap>, ServiceReference1.WebServiceSoap
    {
        
        /// <summary>
        /// Implemente este método parcial para configurar el punto de conexión de servicio.
        /// </summary>
        /// <param name="serviceEndpoint">El punto de conexión para configurar</param>
        /// <param name="clientCredentials">Credenciales de cliente</param>
        static partial void ConfigureEndpoint(System.ServiceModel.Description.ServiceEndpoint serviceEndpoint, System.ServiceModel.Description.ClientCredentials clientCredentials);
        
        public WebServiceSoapClient(EndpointConfiguration endpointConfiguration) : 
                base(WebServiceSoapClient.GetBindingForEndpoint(endpointConfiguration), WebServiceSoapClient.GetEndpointAddress(endpointConfiguration))
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public WebServiceSoapClient(EndpointConfiguration endpointConfiguration, string remoteAddress) : 
                base(WebServiceSoapClient.GetBindingForEndpoint(endpointConfiguration), new System.ServiceModel.EndpointAddress(remoteAddress))
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public WebServiceSoapClient(EndpointConfiguration endpointConfiguration, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(WebServiceSoapClient.GetBindingForEndpoint(endpointConfiguration), remoteAddress)
        {
            this.Endpoint.Name = endpointConfiguration.ToString();
            ConfigureEndpoint(this.Endpoint, this.ClientCredentials);
        }
        
        public WebServiceSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress)
        {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<ServiceReference1.CotizarResponse> ServiceReference1.WebServiceSoap.CotizarAsync(ServiceReference1.CotizarRequest request)
        {
            return base.Channel.CotizarAsync(request);
        }
        
        public System.Threading.Tasks.Task<ServiceReference1.CotizarResponse> CotizarAsync(System.DateTime inicio, System.DateTime fin)
        {
            ServiceReference1.CotizarRequest inValue = new ServiceReference1.CotizarRequest();
            inValue.Body = new ServiceReference1.CotizarRequestBody();
            inValue.Body.inicio = inicio;
            inValue.Body.fin = fin;
            return ((ServiceReference1.WebServiceSoap)(this)).CotizarAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<ServiceReference1.ReservarResponse> ServiceReference1.WebServiceSoap.ReservarAsync(ServiceReference1.ReservarRequest request)
        {
            return base.Channel.ReservarAsync(request);
        }
        
        public System.Threading.Tasks.Task<ServiceReference1.ReservarResponse> ReservarAsync(System.DateTime inicio, System.DateTime fin)
        {
            ServiceReference1.ReservarRequest inValue = new ServiceReference1.ReservarRequest();
            inValue.Body = new ServiceReference1.ReservarRequestBody();
            inValue.Body.inicio = inicio;
            inValue.Body.fin = fin;
            return ((ServiceReference1.WebServiceSoap)(this)).ReservarAsync(inValue);
        }
        
        public virtual System.Threading.Tasks.Task OpenAsync()
        {
            return System.Threading.Tasks.Task.Factory.FromAsync(((System.ServiceModel.ICommunicationObject)(this)).BeginOpen(null, null), new System.Action<System.IAsyncResult>(((System.ServiceModel.ICommunicationObject)(this)).EndOpen));
        }
        
        private static System.ServiceModel.Channels.Binding GetBindingForEndpoint(EndpointConfiguration endpointConfiguration)
        {
            if ((endpointConfiguration == EndpointConfiguration.WebServiceSoap))
            {
                System.ServiceModel.BasicHttpBinding result = new System.ServiceModel.BasicHttpBinding();
                result.MaxBufferSize = int.MaxValue;
                result.ReaderQuotas = System.Xml.XmlDictionaryReaderQuotas.Max;
                result.MaxReceivedMessageSize = int.MaxValue;
                result.AllowCookies = true;
                return result;
            }
            if ((endpointConfiguration == EndpointConfiguration.WebServiceSoap12))
            {
                System.ServiceModel.Channels.CustomBinding result = new System.ServiceModel.Channels.CustomBinding();
                System.ServiceModel.Channels.TextMessageEncodingBindingElement textBindingElement = new System.ServiceModel.Channels.TextMessageEncodingBindingElement();
                textBindingElement.MessageVersion = System.ServiceModel.Channels.MessageVersion.CreateVersion(System.ServiceModel.EnvelopeVersion.Soap12, System.ServiceModel.Channels.AddressingVersion.None);
                result.Elements.Add(textBindingElement);
                System.ServiceModel.Channels.HttpTransportBindingElement httpBindingElement = new System.ServiceModel.Channels.HttpTransportBindingElement();
                httpBindingElement.AllowCookies = true;
                httpBindingElement.MaxBufferSize = int.MaxValue;
                httpBindingElement.MaxReceivedMessageSize = int.MaxValue;
                result.Elements.Add(httpBindingElement);
                return result;
            }
            throw new System.InvalidOperationException(string.Format("No se pudo encontrar un punto de conexión con el nombre \"{0}\".", endpointConfiguration));
        }
        
        private static System.ServiceModel.EndpointAddress GetEndpointAddress(EndpointConfiguration endpointConfiguration)
        {
            if ((endpointConfiguration == EndpointConfiguration.WebServiceSoap))
            {
                return new System.ServiceModel.EndpointAddress("http://localhost:62135/WebService.asmx");
            }
            if ((endpointConfiguration == EndpointConfiguration.WebServiceSoap12))
            {
                return new System.ServiceModel.EndpointAddress("http://localhost:62135/WebService.asmx");
            }
            throw new System.InvalidOperationException(string.Format("No se pudo encontrar un punto de conexión con el nombre \"{0}\".", endpointConfiguration));
        }
        
        public enum EndpointConfiguration
        {
            
            WebServiceSoap,
            
            WebServiceSoap12,
        }
    }
}
