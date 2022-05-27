namespace MusicPlayer
{
    partial class MusicPlayer
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(MusicPlayer));
            this.btnSelect = new System.Windows.Forms.Button();
            this.panel1 = new System.Windows.Forms.Panel();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.logo1 = new System.Windows.Forms.Label();
            this.Songs = new System.Windows.Forms.ListBox();
            this.MuZkplayerwdws = new AxWMPLib.AxWindowsMediaPlayer();
            this.panel2 = new System.Windows.Forms.Panel();
            this.panel1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.MuZkplayerwdws)).BeginInit();
            this.panel2.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnSelect
            // 
            this.btnSelect.BackColor = System.Drawing.Color.LightCoral;
            this.btnSelect.ForeColor = System.Drawing.Color.Gainsboro;
            this.btnSelect.Location = new System.Drawing.Point(632, 411);
            this.btnSelect.Name = "btnSelect";
            this.btnSelect.Size = new System.Drawing.Size(113, 37);
            this.btnSelect.TabIndex = 0;
            this.btnSelect.Text = "Select Songs";
            this.btnSelect.UseVisualStyleBackColor = false;
            this.btnSelect.Click += new System.EventHandler(this.btnSelect_Click);
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.SystemColors.HotTrack;
            this.panel1.Controls.Add(this.pictureBox1);
            this.panel1.Controls.Add(this.logo1);
            this.panel1.Dock = System.Windows.Forms.DockStyle.Top;
            this.panel1.Location = new System.Drawing.Point(0, 0);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(800, 63);
            this.panel1.TabIndex = 1;
            // 
            // pictureBox1
            // 
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(740, 12);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(48, 40);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 1;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.Click += new System.EventHandler(this.pictureBox1_Click);
            // 
            // logo1
            // 
            this.logo1.AutoSize = true;
            this.logo1.Font = new System.Drawing.Font("Bauhaus 93", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.logo1.Location = new System.Drawing.Point(21, 18);
            this.logo1.Name = "logo1";
            this.logo1.Size = new System.Drawing.Size(91, 34);
            this.logo1.TabIndex = 0;
            this.logo1.Text = "MuZk";
            // 
            // Songs
            // 
            this.Songs.BackColor = System.Drawing.SystemColors.InactiveBorder;
            this.Songs.Font = new System.Drawing.Font("Bauhaus 93", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.Songs.FormattingEnabled = true;
            this.Songs.ItemHeight = 15;
            this.Songs.Location = new System.Drawing.Point(569, 86);
            this.Songs.Name = "Songs";
            this.Songs.Size = new System.Drawing.Size(219, 319);
            this.Songs.TabIndex = 2;
            this.Songs.SelectedIndexChanged += new System.EventHandler(this.listSongs_SelectedIndexChanged);
            // 
            // MuZkplayerwdws
            // 
            this.MuZkplayerwdws.Dock = System.Windows.Forms.DockStyle.Fill;
            this.MuZkplayerwdws.Enabled = true;
            this.MuZkplayerwdws.Location = new System.Drawing.Point(0, 0);
            this.MuZkplayerwdws.Name = "MuZkplayerwdws";
            this.MuZkplayerwdws.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("MuZkplayerwdws.OcxState")));
            this.MuZkplayerwdws.Size = new System.Drawing.Size(551, 379);
            this.MuZkplayerwdws.TabIndex = 3;
            // 
            // panel2
            // 
            this.panel2.Controls.Add(this.MuZkplayerwdws);
            this.panel2.Location = new System.Drawing.Point(12, 69);
            this.panel2.Name = "panel2";
            this.panel2.Size = new System.Drawing.Size(551, 379);
            this.panel2.TabIndex = 4;
            // 
            // MusicPlayer
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(800, 481);
            this.Controls.Add(this.panel2);
            this.Controls.Add(this.Songs);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.btnSelect);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "MusicPlayer";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.MusicPlayer_Load);
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.MuZkplayerwdws)).EndInit();
            this.panel2.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnSelect;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.Label logo1;
        private System.Windows.Forms.ListBox Songs;
        private AxWMPLib.AxWindowsMediaPlayer MuZkplayerwdws;
        private System.Windows.Forms.Panel panel2;
    }
}

