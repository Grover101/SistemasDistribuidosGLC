using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConsumirSURECU
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void mostraDatos_Click(object sender, EventArgs e)
        {
            String ci = txtCi.Text;

            Servicio.datosPersonasClient ws = new Servicio.datosPersonasClient();

            resultado.Text = ws.ObtenerDatos(ci).ToString();

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void nacimiento_Click(object sender, EventArgs e)
        {
            String ci = txtCi.Text;

            Servicio.datosPersonasClient ws = new Servicio.datosPersonasClient();

            resultado.Text = ws.ObtenerCertificadoNacimiento(ci).ToString();
        }

        private void matrimonio_Click(object sender, EventArgs e)
        {
            String ci = txtCi.Text;

            Servicio.datosPersonasClient ws = new Servicio.datosPersonasClient();

            resultado.Text = ws.ObtenerCertificadoMatrimonio(ci).ToString();
        }

        private void defuncion_Click(object sender, EventArgs e)
        {
            String ci = txtCi.Text;

            Servicio.datosPersonasClient ws = new Servicio.datosPersonasClient();

            resultado.Text = ws.ObtenerCertificadoDefuncion(ci).ToString();
        }
    }
}
