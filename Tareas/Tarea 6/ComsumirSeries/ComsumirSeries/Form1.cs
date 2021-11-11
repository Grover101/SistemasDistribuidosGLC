using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ComsumirSeries
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnFibonacci_Click(object sender, EventArgs e)
        {
            int n = int.Parse(textN.Text);
            ServicioSeries.wsSeriesSoapClient ws = new ServicioSeries.wsSeriesSoapClient();
            resultado.Text = ws.Fibonacci(n).ToString();
        }

        private void btnFactorial_Click(object sender, EventArgs e)
        {
            int n = int.Parse(textN.Text);
            ServicioSeries.wsSeriesSoapClient ws = new ServicioSeries.wsSeriesSoapClient();
            resultado.Text = ws.Factorial(n).ToString();
        }
    }
}
