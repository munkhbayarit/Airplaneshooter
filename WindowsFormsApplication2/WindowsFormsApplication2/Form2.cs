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
    public partial class Form2 : Form
    {
        private string loginname;
        private string talbai="15x15", ongotstoo="5";//login name.eereee database.ees unshij avnaaa
        public Form2(string n)
        {
            InitializeComponent();
            loginname = n;

        }
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {
            label4.Text = talbai.ToString();
            label6.Text = ongotstoo.ToString();
            for (int i = 1; i < Convert.ToInt32(ongotstoo.ToString()) + 1; i++)
            {
                listBox1.Items.Add(i.ToString());
            }
            
            if (talbai == "10x10") {
                groupBox1.Visible = true;
                groupBox2.Visible = true;
                groupBox4.Visible = false;
                groupBox5.Visible = false;
                
            }
            else if (talbai == "15x15") { 
                   groupBox1.Visible = false;
                   groupBox2.Visible = false;
                   groupBox4.Visible = true;
                   groupBox5.Visible = true;
            }

            
        }

        private void rANKSTATISTICToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Statistic s = new Statistic();
            s.ShowDialog();
        }
    }
}
