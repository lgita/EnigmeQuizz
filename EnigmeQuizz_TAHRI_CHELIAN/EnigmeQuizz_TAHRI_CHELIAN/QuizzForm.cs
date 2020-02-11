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
    public partial class QuizzForm : Form
    {
        Joueur joueur1;
        EnigmeQuizzService service1;
        

        public QuizzForm(EnigmeQuizzService service, Joueur joueur)
        {
            InitializeComponent();
            joueur1 = joueur;
            service1 = service;
            List<String> listheme = new List<string>();
            listheme = service1.QuizzTheme();
            for (int i = 0; i < listheme.Count(); i++)
            {
                domainUpDown1.Items.Add (service1.QuizzTheme().ElementAt(i));
            }
           


        }

        private void button1_Click(object sender, EventArgs e)
        {
            string theme1 = domainUpDown1.Text;
            QuizzQuestion quizzQuestion = new QuizzQuestion(service1, joueur1, theme1);
            quizzQuestion.Show();
        }



    }
}
