using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MusicPlayer
{
    public partial class MusicPlayer : Form
    {
        public MusicPlayer()
        {
            InitializeComponent();
        }


        //String type Arrays for song names

        String[] paths, files;


        private void pictureBox1_Click(object sender, EventArgs e)
        {
            //Close the app
            this.Close();
        }

        private void btnSelect_Click(object sender, EventArgs e)
        {
            //Song Selection
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Multiselect = true;

            if (openFileDialog.ShowDialog() == System.Windows.Forms.DialogResult.OK)
            {
                files = openFileDialog.SafeFileNames; // save the names
                paths = openFileDialog.FileNames; // save the path

                for(int i = 0; i < files.Length; i++)
                {
                    Songs.Items.Add(files[i]);//Show songs in list box
                }

            }
        }

        private void MusicPlayer_Load(object sender, EventArgs e)
        {

        }

        private void listSongs_SelectedIndexChanged(object sender, EventArgs e)
        {
            MuZkplayerwdws.URL = paths[Songs.SelectedIndex];
        }
    }
}
