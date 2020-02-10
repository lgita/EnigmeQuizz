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
    public partial class InterfaceBase : Form
    {
        EnigmeQuizzService service = new EnigmeQuizzService();
        public InterfaceBase()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            ConnexionJoueur connexionJoueur = new ConnexionJoueur(service);
            connexionJoueur.Show();

        }

        private void button2_Click(object sender, EventArgs e)
        {
            InscriptionJoueur inscriptionJoueur = new InscriptionJoueur(service);
            inscriptionJoueur.Show();
        }


    }
}
