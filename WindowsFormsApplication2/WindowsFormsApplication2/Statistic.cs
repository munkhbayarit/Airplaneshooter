using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace WindowsFormsApplication2
{
    public partial class Statistic : Form
    {
        public Statistic()
        {
            InitializeComponent();
        }

        private void createGameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Statistic s = new Statistic();
            s.ShowDialog();
        }
    }
}
