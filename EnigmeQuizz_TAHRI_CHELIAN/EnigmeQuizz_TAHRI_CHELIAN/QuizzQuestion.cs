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
        string reponse;
        public QuizzQuestion(EnigmeQuizzService service, Joueur joueur, String themequizz)
        {
            InitializeComponent();
            joueur1 = joueur;
            service1 = service;
            themesouhaite = themequizz;
            label1.Text = "Vous avez choisi le theme " + "" + themequizz;
            List<String> questionQuizzs = service1.QuestionQuizzpartheme(themesouhaite);
            int nb = questionQuizzs.Count();
            for (int i = 0; i < nb; i++)
            {

                label2.Text = questionQuizzs.ElementAt(i).ToString();
                List<String> reponsequestion = service1.ReponseQuizzparQuestion(label2.Text);

                int nbreponse = reponsequestion.Count();
                if (nbreponse == 3)
                {
                    radioButton1.Text = reponsequestion.ElementAt(0).ToString();
                    radioButton2.Text = reponsequestion.ElementAt(1).ToString();
                    radioButton3.Text = reponsequestion.ElementAt(2).ToString();
                }
                else
                {
                    MessageBox.Show("Le nombre de réponse n'est pas suffisante");
                }

            }



        }





        private void button1_Click(object sender, EventArgs e)
        {
            QuestionQuizz questionQuizz = service1.RechercheQuestionQuizz(label2.Text);
            ReponseQuizz reponsejuste = service1.RechercheReponseTrueQuizz(label2.Text);
            groupBox1.Controls.Add(radioButton1);
            groupBox1.Controls.Add(radioButton2);
            groupBox1.Controls.Add(radioButton3);


            foreach (RadioButton RB in groupBox1.Controls)
            {
                if (RB.Checked == true)
                {
                    reponse = RB.Text;
                    MessageBox.Show("Vous avez choisi la réponse suivante : " + reponse);
                }

            }
                ReponseQuizz reponseselectionne = service1.RechercheReponseQuizz(reponse);
            
            if (reponseselectionne.isTrue.Contains(reponsejuste.reponseQuizz1))
                {
                    MessageBox.Show("Bien joué +3 points");
                    int score = (int)joueur1.scoreJoueur;
                    int nouveauscore = score + 3;
                    int confirmationscore = service1.modificationScore(joueur1, nouveauscore);
                    MessageBox.Show("Votre score est maintenant de" + confirmationscore);



            }
                else
                {

                    MessageBox.Show("Dommage, retentez votre chance ! " +
                        "La réponse était" + reponsejuste.reponseQuizz1);



                }

            }

        }
    
}

    
    

