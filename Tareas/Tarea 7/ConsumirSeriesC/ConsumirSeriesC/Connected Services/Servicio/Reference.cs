﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ConsumirSeriesC.Servicio {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://servicios/", ConfigurationName="Servicio.wsSeries")]
    public interface wsSeries {
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el espacio de nombres de partes de mensaje () no coincide con el valor predeterminado (http://servicios/).
        [System.ServiceModel.OperationContractAttribute(Action="http://servicios/wsSeries/FibonacciRequest", ReplyAction="http://servicios/wsSeries/FibonacciResponse")]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        ConsumirSeriesC.Servicio.FibonacciResponse Fibonacci(ConsumirSeriesC.Servicio.FibonacciRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://servicios/wsSeries/FibonacciRequest", ReplyAction="http://servicios/wsSeries/FibonacciResponse")]
        System.Threading.Tasks.Task<ConsumirSeriesC.Servicio.FibonacciResponse> FibonacciAsync(ConsumirSeriesC.Servicio.FibonacciRequest request);
        
        // CODEGEN: Se está generando un contrato de mensaje, ya que el espacio de nombres de partes de mensaje () no coincide con el valor predeterminado (http://servicios/).
        [System.ServiceModel.OperationContractAttribute(Action="http://servicios/wsSeries/FactorialRequest", ReplyAction="http://servicios/wsSeries/FactorialResponse")]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        ConsumirSeriesC.Servicio.FactorialResponse Factorial(ConsumirSeriesC.Servicio.FactorialRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://servicios/wsSeries/FactorialRequest", ReplyAction="http://servicios/wsSeries/FactorialResponse")]
        System.Threading.Tasks.Task<ConsumirSeriesC.Servicio.FactorialResponse> FactorialAsync(ConsumirSeriesC.Servicio.FactorialRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="Fibonacci", WrapperNamespace="http://servicios/", IsWrapped=true)]
    public partial class FibonacciRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        public int n;
        
        public FibonacciRequest() {
        }
        
        public FibonacciRequest(int n) {
            this.n = n;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="FibonacciResponse", WrapperNamespace="http://servicios/", IsWrapped=true)]
    public partial class FibonacciResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        public int @return;
        
        public FibonacciResponse() {
        }
        
        public FibonacciResponse(int @return) {
            this.@return = @return;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="Factorial", WrapperNamespace="http://servicios/", IsWrapped=true)]
    public partial class FactorialRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        public int n;
        
        public FactorialRequest() {
        }
        
        public FactorialRequest(int n) {
            this.n = n;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="FactorialResponse", WrapperNamespace="http://servicios/", IsWrapped=true)]
    public partial class FactorialResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="", Order=0)]
        public int @return;
        
        public FactorialResponse() {
        }
        
        public FactorialResponse(int @return) {
            this.@return = @return;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface wsSeriesChannel : ConsumirSeriesC.Servicio.wsSeries, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class wsSeriesClient : System.ServiceModel.ClientBase<ConsumirSeriesC.Servicio.wsSeries>, ConsumirSeriesC.Servicio.wsSeries {
        
        public wsSeriesClient() {
        }
        
        public wsSeriesClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public wsSeriesClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public wsSeriesClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public wsSeriesClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        ConsumirSeriesC.Servicio.FibonacciResponse ConsumirSeriesC.Servicio.wsSeries.Fibonacci(ConsumirSeriesC.Servicio.FibonacciRequest request) {
            return base.Channel.Fibonacci(request);
        }
        
        public int Fibonacci(int n) {
            ConsumirSeriesC.Servicio.FibonacciRequest inValue = new ConsumirSeriesC.Servicio.FibonacciRequest();
            inValue.n = n;
            ConsumirSeriesC.Servicio.FibonacciResponse retVal = ((ConsumirSeriesC.Servicio.wsSeries)(this)).Fibonacci(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<ConsumirSeriesC.Servicio.FibonacciResponse> ConsumirSeriesC.Servicio.wsSeries.FibonacciAsync(ConsumirSeriesC.Servicio.FibonacciRequest request) {
            return base.Channel.FibonacciAsync(request);
        }
        
        public System.Threading.Tasks.Task<ConsumirSeriesC.Servicio.FibonacciResponse> FibonacciAsync(int n) {
            ConsumirSeriesC.Servicio.FibonacciRequest inValue = new ConsumirSeriesC.Servicio.FibonacciRequest();
            inValue.n = n;
            return ((ConsumirSeriesC.Servicio.wsSeries)(this)).FibonacciAsync(inValue);
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        ConsumirSeriesC.Servicio.FactorialResponse ConsumirSeriesC.Servicio.wsSeries.Factorial(ConsumirSeriesC.Servicio.FactorialRequest request) {
            return base.Channel.Factorial(request);
        }
        
        public int Factorial(int n) {
            ConsumirSeriesC.Servicio.FactorialRequest inValue = new ConsumirSeriesC.Servicio.FactorialRequest();
            inValue.n = n;
            ConsumirSeriesC.Servicio.FactorialResponse retVal = ((ConsumirSeriesC.Servicio.wsSeries)(this)).Factorial(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<ConsumirSeriesC.Servicio.FactorialResponse> ConsumirSeriesC.Servicio.wsSeries.FactorialAsync(ConsumirSeriesC.Servicio.FactorialRequest request) {
            return base.Channel.FactorialAsync(request);
        }
        
        public System.Threading.Tasks.Task<ConsumirSeriesC.Servicio.FactorialResponse> FactorialAsync(int n) {
            ConsumirSeriesC.Servicio.FactorialRequest inValue = new ConsumirSeriesC.Servicio.FactorialRequest();
            inValue.n = n;
            return ((ConsumirSeriesC.Servicio.wsSeries)(this)).FactorialAsync(inValue);
        }
    }
}
