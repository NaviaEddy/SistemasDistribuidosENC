namespace ConsumirServicios
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
            comboBoxServicios = new ComboBox();
            labelResultado = new Label();
            buttonConsumir = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(273, 33);
            label1.Name = "label1";
            label1.Size = new Size(193, 20);
            label1.TabIndex = 0;
            label1.Text = "CONSUMIR REST-GRAPHQL";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(136, 80);
            label2.Name = "label2";
            label2.Size = new Size(115, 20);
            label2.TabIndex = 1;
            label2.Text = "Elige el servicio:";
            // 
            // comboBoxServicios
            // 
            comboBoxServicios.FormattingEnabled = true;
            comboBoxServicios.Items.AddRange(new object[] { "Rest", "GraphQL" });
            comboBoxServicios.Location = new Point(257, 77);
            comboBoxServicios.Name = "comboBoxServicios";
            comboBoxServicios.Size = new Size(249, 28);
            comboBoxServicios.TabIndex = 2;
            comboBoxServicios.SelectedIndexChanged += comboBoxServicios_SelectedIndexChanged;
            // 
            // labelResultado
            // 
            labelResultado.BorderStyle = BorderStyle.FixedSingle;
            labelResultado.Location = new Point(65, 129);
            labelResultado.Name = "labelResultado";
            labelResultado.Size = new Size(659, 283);
            labelResultado.TabIndex = 3;
            labelResultado.Click += labelResultado_Click;
            // 
            // buttonConsumir
            // 
            buttonConsumir.Location = new Point(541, 76);
            buttonConsumir.Name = "buttonConsumir";
            buttonConsumir.Size = new Size(94, 29);
            buttonConsumir.TabIndex = 4;
            buttonConsumir.Text = "Consumir";
            buttonConsumir.UseVisualStyleBackColor = true;
            buttonConsumir.Click += buttonConsumir_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(buttonConsumir);
            Controls.Add(labelResultado);
            Controls.Add(comboBoxServicios);
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
        private ComboBox comboBoxServicios;
        private Label labelResultado;
        private Button buttonConsumir;
    }
}
