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
        int i = 0;
        public QuizzQuestion(EnigmeQuizzService service, Joueur joueur, String themequizz)
        {
            InitializeComponent();
            joueur1 = joueur;
            service1 = service;
            themesouhaite = themequizz;
            label1.Text = "Vous avez choisi le theme " +themequizz;
            List<String> questionQuizzs = service1.QuestionQuizzpartheme(themesouhaite);
            label2.Text = questionQuizzs.ElementAt(i).ToString();
            string question = label2.Text;
            i++;
            List<String> reponseQuizz = service1.ReponsesQuizzparquestion(question);
            int nb = reponseQuizz.Count();
            for (int i = 0; i < nb ; i++)
            {
                //radioButton1.Text = reponseQuizz
            }

        }


    }
}
