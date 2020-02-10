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
    public partial class QuizzQuestion : Form
    {
        Joueur joueur1;
        EnigmeQuizzService service1;
        String themesouhaite;
        public QuizzQuestion(EnigmeQuizzService service, Joueur joueur, String themequizz)
        {
            InitializeComponent();
            this.Visible = false;
            joueur1 = joueur;
            service1 = service;
            themesouhaite = themequizz;
            label1.Text = "Vous avez choisi le theme " +themequizz;
            List<QuestionQuizz> questionQuizzs = service1.QuestionQuizzpartheme(themesouhaite);
            int nb = questionQuizzs.Count();
            label2.Text = questionQuizzs.ElementAt(nb-1).ToString();

        }

        private void label2_Click(object sender, EventArgs e)
        {
            this.Visible = false;
        }

        private void label1_Click(object sender, EventArgs e)
        {
            this.Visible = false;
        }
    }
}
