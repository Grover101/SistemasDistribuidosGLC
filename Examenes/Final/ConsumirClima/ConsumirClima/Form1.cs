using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsumirClima
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnTemperatura_Click(object sender, EventArgs e)
        {
            String fecha = textFecha.Text;
            servicio.wsClimaClient ws = new servicio.wsClimaClient();
            resultado.Text = ws.Temperatura("t", fecha);
        }

        private void btnPorcentaje_Click(object sender, EventArgs e)
        {
            String fecha = textFecha.Text;
            servicio.wsClimaClient ws = new servicio.wsClimaClient();
            resultado.Text = ws.Temperatura("p", fecha);
        }
    }
}
