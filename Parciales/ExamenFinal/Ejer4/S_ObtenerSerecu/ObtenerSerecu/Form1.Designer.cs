namespace ObtenerSerecu
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
            label1 = new Label();
            label2 = new Label();
            textBoxCI = new TextBox();
            comboBoxSerecu = new ComboBox();
            labelResultados = new Label();
            buttonGenerar = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(355, 34);
            label1.Name = "label1";
            label1.Size = new Size(61, 20);
            label1.TabIndex = 0;
            label1.Text = "SERECU";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(95, 73);
            label2.Name = "label2";
            label2.Size = new Size(77, 20);
            label2.TabIndex = 1;
            label2.Text = "Ingrese CI:";
            // 
            // textBoxCI
            // 
            textBoxCI.Location = new Point(178, 70);
            textBoxCI.Name = "textBoxCI";
            textBoxCI.Size = new Size(208, 27);
            textBoxCI.TabIndex = 2;
            textBoxCI.TextChanged += textBoxCI_TextChanged;
            // 
            // comboBoxSerecu
            // 
            comboBoxSerecu.FormattingEnabled = true;
            comboBoxSerecu.Items.AddRange(new object[] { "Obtener Datos", "Obtener Cert. Nacimiento" });
            comboBoxSerecu.Location = new Point(403, 70);
            comboBoxSerecu.Name = "comboBoxSerecu";
            comboBoxSerecu.Size = new Size(205, 28);
            comboBoxSerecu.TabIndex = 3;
            comboBoxSerecu.SelectedIndexChanged += comboBoxSerecu_SelectedIndexChanged;
            // 
            // labelResultados
            // 
            labelResultados.BorderStyle = BorderStyle.FixedSingle;
            labelResultados.Location = new Point(67, 183);
            labelResultados.Name = "labelResultados";
            labelResultados.Size = new Size(654, 238);
            labelResultados.TabIndex = 4;
            labelResultados.Click += labelResultados_Click;
            // 
            // buttonGenerar
            // 
            buttonGenerar.Location = new Point(334, 130);
            buttonGenerar.Name = "buttonGenerar";
            buttonGenerar.Size = new Size(94, 29);
            buttonGenerar.TabIndex = 5;
            buttonGenerar.Text = "Enviar";
            buttonGenerar.UseVisualStyleBackColor = true;
            buttonGenerar.Click += buttonGenerar_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(buttonGenerar);
            Controls.Add(labelResultados);
            Controls.Add(comboBoxSerecu);
            Controls.Add(textBoxCI);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private TextBox textBoxCI;
        private ComboBox comboBoxSerecu;
        private Label labelResultados;
        private Button buttonGenerar;
    }
}
