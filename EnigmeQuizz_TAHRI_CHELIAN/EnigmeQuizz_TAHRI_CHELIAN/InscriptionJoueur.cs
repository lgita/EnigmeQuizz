using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EnigmeQuizz_TAHRI_CHELIAN
{
    public partial class InscriptionJoueur : Form
    {
        EnigmeQuizzService service = new EnigmeQuizzService();
        public InscriptionJoueur()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String pseudo = textBox1.Text;
            String mdp = textBox2.Text;
            service.CreationJoueur(pseudo, mdp);
            MenuGeneral menuGeneral = new MenuGeneral();
            menuGeneral.Show();
        }
    }
}
