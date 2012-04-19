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
    public partial class Form1 : Form
    {
        private string loginname;  ///nevterch orj irsen hunii ner ongots bairluulah Form2 gesen ruu damjuulj ogogdliin sangaas ongotsnii too talbaig avna
        public Form1()
        {
            InitializeComponent();
        }
        private void Form1_Load(object sender, EventArgs e)
        {
            groupBox1.Visible = false;
            comboBox1.Items.Add("10x10");
            comboBox1.Items.Add("15x15");

        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox1.Text == "10x10") {
                for (int i = 1; i < 9; i++) {
                    comboBox2.Items.Add(i.ToString());
                }
            }
            else if(comboBox1.Text=="15x15"){
                for (int i = 1; i < 15; i++)
                {
                    comboBox2.Items.Add(i.ToString());
                }
            }
            else MessageBox.Show("Таны оруулсан талбайн тоо  буруу байнаа");
        }

        private void comboBox2_SelectedIndexChanged(object sender, EventArgs e)
        {
            int check;
            check = Convert.ToInt32(comboBox2.Text.ToString());
            if (comboBox1.Text == "10x10") {
                
                if(check>8&&check<1)
                    MessageBox.Show("ТА боломжит бус онгоцны дугаар оруулсан байна Анхаар!!!!");
            }
            else if (comboBox1.Text == "15x15") {
                if (check > 16&& check < 1)
                    MessageBox.Show("ТА боломжит бус онгоцны дугаар оруулсан байна Анхаар!!!!");
            }
            else MessageBox.Show("Таны оруулсан талбайн тоо  буруу байнаа");

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            label2.Text = listBox1.SelectedItem.ToString();
            if (listBox1.SelectedItem != "******ТОГЛОХ УУ******"&&listBox1.SelectedItem!=" ")
            groupBox1.Visible = true;
            else MessageBox.Show("Error!!!!!!!");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            /// create game geh database table.d ene ogogdoluudiig nemne createtable ni id,toglogchiin ner,orsoldogch ner ,ongotsnii too,talbai,onsar odor gesen column.tai bna
            /// esvel ongotsnii too talbaig oor husnegtend hadgalj bolno
            if (comboBox1.Text == "10x10")
            {

                if (Convert.ToInt32(Text.ToString()) > 8)
                    MessageBox.Show("ТА боломжит бус онгоцны дугаар оруулсан байна Анхаар!!!!");
                else { 
                    groupBox1.Visible = false;
                    Form2 f = new Form2(loginname);
                    f.ShowDialog();
                }
            }
            else if (comboBox1.Text == "15x15")
            {
                if (Convert.ToInt32(Text.ToString()) > 16 && Convert.ToInt32(Text.ToString()) < 1)
                    MessageBox.Show("ТА боломжит бус онгоцны дугаар оруулсан байна Анхаар!!!!");
                else { 
                    groupBox1.Visible = false;
                    Form2 f = new Form2(loginname);
                    f.ShowDialog();
                }
            }
            else MessageBox.Show("Таны оруулсан талбайн тоо  буруу байнаа");



        }

        private void button2_Click(object sender, EventArgs e)
        {
            groupBox1.Visible = false;

        }

        private void playToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f1 = new Form2();
            f1.ShowDialog();
        }

        private void createGameToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Statistic s = new Statistic();
            s.ShowDialog();
        }
    }
}
