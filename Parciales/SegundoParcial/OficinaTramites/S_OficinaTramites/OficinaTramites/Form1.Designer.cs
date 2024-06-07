namespace OficinaTramites
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
            SEGIP = new Label();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            buttonVerificarDatos = new Button();
            label7 = new Label();
            button1 = new Button();
            panelDatos = new Panel();
            labelDatos = new Label();
            textBoxCIVerificar = new TextBox();
            textBoxNombres = new TextBox();
            textBoxPrimerApellido = new TextBox();
            textBoxSegundoApellido = new TextBox();
            textBoxCIObtener = new TextBox();
            panelSeduca = new Panel();
            panelAcademico = new Panel();
            labelSeduca = new TextBox();
            labelAcademico = new TextBox();
            panelDatos.SuspendLayout();
            panelSeduca.SuspendLayout();
            panelAcademico.SuspendLayout();
            SuspendLayout();
            // 
            // SEGIP
            // 
            SEGIP.AutoSize = true;
            SEGIP.Location = new Point(231, 9);
            SEGIP.Name = "SEGIP";
            SEGIP.Size = new Size(47, 20);
            SEGIP.TabIndex = 0;
            SEGIP.Text = "SEGIP";
            SEGIP.Click += label1_Click;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(897, 9);
            label1.Name = "label1";
            label1.Size = new Size(65, 20);
            label1.TabIndex = 1;
            label1.Text = "SEDUCA";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(897, 293);
            label2.Name = "label2";
            label2.Size = new Size(94, 20);
            label2.TabIndex = 2;
            label2.Text = "ACADEMICO";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(111, 35);
            label3.Name = "label3";
            label3.Size = new Size(25, 20);
            label3.TabIndex = 3;
            label3.Text = "CI:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(63, 70);
            label4.Name = "label4";
            label4.Size = new Size(73, 20);
            label4.TabIndex = 4;
            label4.Text = "Nombres:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(24, 102);
            label5.Name = "label5";
            label5.Size = new Size(112, 20);
            label5.TabIndex = 5;
            label5.Text = "PrimerApellido:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(8, 134);
            label6.Name = "label6";
            label6.Size = new Size(128, 20);
            label6.TabIndex = 6;
            label6.Text = "SegundoApellido:";
            // 
            // buttonVerificarDatos
            // 
            buttonVerificarDatos.Location = new Point(174, 167);
            buttonVerificarDatos.Name = "buttonVerificarDatos";
            buttonVerificarDatos.Size = new Size(136, 29);
            buttonVerificarDatos.TabIndex = 7;
            buttonVerificarDatos.Text = "VerificarDatos";
            buttonVerificarDatos.UseVisualStyleBackColor = true;
            buttonVerificarDatos.Click += buttonVerificarDatos_Click;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(111, 222);
            label7.Name = "label7";
            label7.Size = new Size(25, 20);
            label7.TabIndex = 8;
            label7.Text = "CI:";
            // 
            // button1
            // 
            button1.Location = new Point(183, 252);
            button1.Name = "button1";
            button1.Size = new Size(136, 29);
            button1.TabIndex = 9;
            button1.Text = "ObtenerDatos";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // panelDatos
            // 
            panelDatos.Controls.Add(labelDatos);
            panelDatos.Location = new Point(24, 304);
            panelDatos.Name = "panelDatos";
            panelDatos.Size = new Size(520, 289);
            panelDatos.TabIndex = 10;
            // 
            // labelDatos
            // 
            labelDatos.Location = new Point(22, 20);
            labelDatos.Name = "labelDatos";
            labelDatos.Size = new Size(467, 248);
            labelDatos.TabIndex = 11;
            // 
            // textBoxCIVerificar
            // 
            textBoxCIVerificar.Location = new Point(142, 32);
            textBoxCIVerificar.Name = "textBoxCIVerificar";
            textBoxCIVerificar.Size = new Size(230, 27);
            textBoxCIVerificar.TabIndex = 11;
            // 
            // textBoxNombres
            // 
            textBoxNombres.Location = new Point(139, 65);
            textBoxNombres.Name = "textBoxNombres";
            textBoxNombres.Size = new Size(233, 27);
            textBoxNombres.TabIndex = 12;
            // 
            // textBoxPrimerApellido
            // 
            textBoxPrimerApellido.Location = new Point(139, 99);
            textBoxPrimerApellido.Name = "textBoxPrimerApellido";
            textBoxPrimerApellido.Size = new Size(233, 27);
            textBoxPrimerApellido.TabIndex = 13;
            // 
            // textBoxSegundoApellido
            // 
            textBoxSegundoApellido.Location = new Point(139, 134);
            textBoxSegundoApellido.Name = "textBoxSegundoApellido";
            textBoxSegundoApellido.Size = new Size(233, 27);
            textBoxSegundoApellido.TabIndex = 14;
            // 
            // textBoxCIObtener
            // 
            textBoxCIObtener.Location = new Point(142, 219);
            textBoxCIObtener.Name = "textBoxCIObtener";
            textBoxCIObtener.Size = new Size(230, 27);
            textBoxCIObtener.TabIndex = 15;
            // 
            // panelSeduca
            // 
            panelSeduca.Controls.Add(labelSeduca);
            panelSeduca.Location = new Point(622, 55);
            panelSeduca.Name = "panelSeduca";
            panelSeduca.Size = new Size(651, 198);
            panelSeduca.TabIndex = 16;
            // 
            // panelAcademico
            // 
            panelAcademico.Controls.Add(labelAcademico);
            panelAcademico.Location = new Point(622, 339);
            panelAcademico.Name = "panelAcademico";
            panelAcademico.Size = new Size(651, 233);
            panelAcademico.TabIndex = 17;
            // 
            // labelSeduca
            // 
            labelSeduca.Location = new Point(3, 3);
            labelSeduca.Multiline = true;
            labelSeduca.Name = "labelSeduca";
            labelSeduca.Size = new Size(645, 188);
            labelSeduca.TabIndex = 0;
            // 
            // labelAcademico
            // 
            labelAcademico.Location = new Point(3, 3);
            labelAcademico.Multiline = true;
            labelAcademico.Name = "labelAcademico";
            labelAcademico.Size = new Size(645, 227);
            labelAcademico.TabIndex = 0;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(1326, 623);
            Controls.Add(panelAcademico);
            Controls.Add(panelSeduca);
            Controls.Add(textBoxCIObtener);
            Controls.Add(textBoxSegundoApellido);
            Controls.Add(textBoxPrimerApellido);
            Controls.Add(textBoxNombres);
            Controls.Add(textBoxCIVerificar);
            Controls.Add(panelDatos);
            Controls.Add(button1);
            Controls.Add(label7);
            Controls.Add(buttonVerificarDatos);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(SEGIP);
            Name = "Form1";
            Text = "Form1";
            panelDatos.ResumeLayout(false);
            panelSeduca.ResumeLayout(false);
            panelSeduca.PerformLayout();
            panelAcademico.ResumeLayout(false);
            panelAcademico.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label SEGIP;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Button buttonVerificarDatos;
        private Label label7;
        private Button button1;
        private Panel panelDatos;
        private Label labelDatos;
        private TextBox textBoxCIVerificar;
        private TextBox textBoxNombres;
        private TextBox textBoxPrimerApellido;
        private TextBox textBoxSegundoApellido;
        private TextBox textBoxCIObtener;
        private Panel panelSeduca;
        private Panel panelAcademico;
        private TextBox labelSeduca;
        private TextBox labelAcademico;
    }
}
