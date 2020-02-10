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
    public partial class EnigmeForm : Form

    {
        Joueur joueur1;
        EnigmeQuizzService service1;


        public EnigmeForm(EnigmeQuizzService service, Joueur joueur)
        {
            InitializeComponent();
            joueur1 = joueur;
            service1 = service;
            Enigme enigmet = service1.EnigmechoisiauHasard();
            this.label2.Text = enigmet.enigme1;

        }
        
        private void button1_Click(object sender, EventArgs e)
            {

                string reponse = textBox1.Text;
            string corpsenigme = label2.Text;
           Enigme enigmebonne= service1.RechercheEnigme(corpsenigme);

                if (reponse == enigmebonne.reponseEnigme) {
                    MessageBox.Show("Bien joué +3 points");
                    int score = (int) joueur1.scoreJoueur;
                    int nouveauscore = score + 3;
                    int confirmationscore = service1.modificationScore(joueur1, nouveauscore);
                    MessageBox.Show("Votre score est maintenant de" + confirmationscore);


            }
            else
            {
                MessageBox.Show("Dommage, retentez votre chance ! " +
                    "La réponse était" + enigmebonne.reponseEnigme);
              

            }
            
        }
    }
}
