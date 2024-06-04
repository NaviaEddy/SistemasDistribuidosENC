namespace ObtenerDatosForm
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            labelCedula = new Label();
            textBoxCedula = new TextBox();
            comboBoxTipoDocumento = new ComboBox();
            labelDocumento = new Label();
            panelDatos = new Panel();
            labelDatosResultados = new Label();
            label1 = new Label();
            buttonGenerar = new Button();
            panelDatos.SuspendLayout();
            SuspendLayout();
            // 
            // labelCedula
            // 
            labelCedula.AutoSize = true;
            labelCedula.Location = new Point(163, 90);
            labelCedula.Name = "labelCedula";
            labelCedula.Size = new Size(151, 20);
            labelCedula.TabIndex = 0;
            labelCedula.Text = "Cedula de identidad: ";
            // 
            // textBoxCedula
            // 
            textBoxCedula.Location = new Point(335, 87);
            textBoxCedula.Name = "textBoxCedula";
            textBoxCedula.Size = new Size(213, 27);
            textBoxCedula.TabIndex = 1;
            textBoxCedula.TextChanged += textBoxCedula_TextChanged;
            // 
            // comboBoxTipoDocumento
            // 
            comboBoxTipoDocumento.FormattingEnabled = true;
            comboBoxTipoDocumento.Items.AddRange(new object[] { "Datos personales", "Certificado de nacimiento", "Certificado de matrimonio", "Certificado de defuncion" });
            comboBoxTipoDocumento.Location = new Point(335, 146);
            comboBoxTipoDocumento.Name = "comboBoxTipoDocumento";
            comboBoxTipoDocumento.Size = new Size(257, 28);
            comboBoxTipoDocumento.TabIndex = 2;
            comboBoxTipoDocumento.SelectedIndexChanged += comboBoxTipoDocumento_SelectedIndexChanged;
            // 
            // labelDocumento
            // 
            labelDocumento.AutoSize = true;
            labelDocumento.Location = new Point(171, 149);
            labelDocumento.Name = "labelDocumento";
            labelDocumento.Size = new Size(143, 20);
            labelDocumento.TabIndex = 3;
            labelDocumento.Text = "Tipo de documento:";
            // 
            // panelDatos
            // 
            panelDatos.Controls.Add(labelDatosResultados);
            panelDatos.Location = new Point(63, 241);
            panelDatos.Name = "panelDatos";
            panelDatos.Size = new Size(692, 159);
            panelDatos.TabIndex = 4;
            // 
            // labelDatosResultados
            // 
            labelDatosResultados.Location = new Point(20, 22);
            labelDatosResultados.Name = "labelDatosResultados";
            labelDatosResultados.Size = new Size(636, 111);
            labelDatosResultados.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(63, 218);
            label1.Name = "label1";
            label1.Size = new Size(84, 20);
            label1.TabIndex = 5;
            label1.Text = "Resultados:";
            // 
            // buttonGenerar
            // 
            buttonGenerar.Location = new Point(610, 146);
            buttonGenerar.Name = "buttonGenerar";
            buttonGenerar.Size = new Size(94, 29);
            buttonGenerar.TabIndex = 6;
            buttonGenerar.Text = "Generar";
            buttonGenerar.UseVisualStyleBackColor = true;
            buttonGenerar.Click += buttonGenerar_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(buttonGenerar);
            Controls.Add(label1);
            Controls.Add(panelDatos);
            Controls.Add(labelDocumento);
            Controls.Add(comboBoxTipoDocumento);
            Controls.Add(textBoxCedula);
            Controls.Add(labelCedula);
            Name = "Form1";
            Text = "Form1";
            panelDatos.ResumeLayout(false);
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label labelCedula;
        private TextBox textBoxCedula;
        private ComboBox comboBoxTipoDocumento;
        private Label labelDocumento;
        private Panel panelDatos;
        private Label labelDatosResultados;
        private Label label1;
        private Button buttonGenerar;
    }
}
