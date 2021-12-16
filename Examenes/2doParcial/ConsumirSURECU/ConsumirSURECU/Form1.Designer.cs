
namespace ConsumirSURECU
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.mostraDatos = new System.Windows.Forms.Button();
            this.txtCi = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.resultado = new System.Windows.Forms.Label();
            this.nacimiento = new System.Windows.Forms.Button();
            this.matrimonio = new System.Windows.Forms.Button();
            this.defuncion = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // mostraDatos
            // 
            this.mostraDatos.Location = new System.Drawing.Point(212, 145);
            this.mostraDatos.Name = "mostraDatos";
            this.mostraDatos.Size = new System.Drawing.Size(109, 23);
            this.mostraDatos.TabIndex = 0;
            this.mostraDatos.Text = "Mostrar Datos";
            this.mostraDatos.UseVisualStyleBackColor = true;
            this.mostraDatos.Click += new System.EventHandler(this.mostraDatos_Click);
            // 
            // txtCi
            // 
            this.txtCi.Location = new System.Drawing.Point(312, 94);
            this.txtCi.Name = "txtCi";
            this.txtCi.Size = new System.Drawing.Size(100, 20);
            this.txtCi.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(260, 97);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(17, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "CI";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(260, 275);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(61, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Respuesta:";
            // 
            // resultado
            // 
            this.resultado.AutoSize = true;
            this.resultado.Location = new System.Drawing.Point(309, 308);
            this.resultado.Name = "resultado";
            this.resultado.Size = new System.Drawing.Size(0, 13);
            this.resultado.TabIndex = 5;
            // 
            // nacimiento
            // 
            this.nacimiento.Location = new System.Drawing.Point(372, 145);
            this.nacimiento.Name = "nacimiento";
            this.nacimiento.Size = new System.Drawing.Size(141, 23);
            this.nacimiento.TabIndex = 6;
            this.nacimiento.Text = "Certificado De Nacimiento";
            this.nacimiento.UseVisualStyleBackColor = true;
            this.nacimiento.Click += new System.EventHandler(this.nacimiento_Click);
            // 
            // matrimonio
            // 
            this.matrimonio.Location = new System.Drawing.Point(195, 196);
            this.matrimonio.Name = "matrimonio";
            this.matrimonio.Size = new System.Drawing.Size(139, 23);
            this.matrimonio.TabIndex = 7;
            this.matrimonio.Text = "Certificado de Matrimonio";
            this.matrimonio.UseVisualStyleBackColor = true;
            this.matrimonio.Click += new System.EventHandler(this.matrimonio_Click);
            // 
            // defuncion
            // 
            this.defuncion.Location = new System.Drawing.Point(372, 196);
            this.defuncion.Name = "defuncion";
            this.defuncion.Size = new System.Drawing.Size(134, 23);
            this.defuncion.TabIndex = 8;
            this.defuncion.Text = "Certificado de Defuncion";
            this.defuncion.UseVisualStyleBackColor = true;
            this.defuncion.Click += new System.EventHandler(this.defuncion_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.defuncion);
            this.Controls.Add(this.matrimonio);
            this.Controls.Add(this.nacimiento);
            this.Controls.Add(this.resultado);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtCi);
            this.Controls.Add(this.mostraDatos);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button mostraDatos;
        private System.Windows.Forms.TextBox txtCi;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label resultado;
        private System.Windows.Forms.Button nacimiento;
        private System.Windows.Forms.Button matrimonio;
        private System.Windows.Forms.Button defuncion;
    }
}

