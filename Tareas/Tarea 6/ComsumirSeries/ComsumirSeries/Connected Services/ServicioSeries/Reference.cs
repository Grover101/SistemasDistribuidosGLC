﻿//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ComsumirSeries.ServicioSeries {
    
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="ServicioSeries.wsSeriesSoap")]
    public interface wsSeriesSoap {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Fibonacci", ReplyAction="*")]
        int Fibonacci(int n);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Fibonacci", ReplyAction="*")]
        System.Threading.Tasks.Task<int> FibonacciAsync(int n);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Factorial", ReplyAction="*")]
        long Factorial(int n);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/Factorial", ReplyAction="*")]
        System.Threading.Tasks.Task<long> FactorialAsync(int n);
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface wsSeriesSoapChannel : ComsumirSeries.ServicioSeries.wsSeriesSoap, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class wsSeriesSoapClient : System.ServiceModel.ClientBase<ComsumirSeries.ServicioSeries.wsSeriesSoap>, ComsumirSeries.ServicioSeries.wsSeriesSoap {
        
        public wsSeriesSoapClient() {
        }
        
        public wsSeriesSoapClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public wsSeriesSoapClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public wsSeriesSoapClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public wsSeriesSoapClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public int Fibonacci(int n) {
            return base.Channel.Fibonacci(n);
        }
        
        public System.Threading.Tasks.Task<int> FibonacciAsync(int n) {
            return base.Channel.FibonacciAsync(n);
        }
        
        public long Factorial(int n) {
            return base.Channel.Factorial(n);
        }
        
        public System.Threading.Tasks.Task<long> FactorialAsync(int n) {
            return base.Channel.FactorialAsync(n);
        }
    }
}
