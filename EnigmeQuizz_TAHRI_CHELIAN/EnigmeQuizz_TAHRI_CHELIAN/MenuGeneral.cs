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
    public partial class MenuGeneral : Form
    {
        Joueur joueur1;
        EnigmeQuizzService service1;

        public MenuGeneral(EnigmeQuizzService service, Joueur joueur)
        {
            InitializeComponent();
            joueur1 = joueur;
            service1 = service;
            this.label3.Text = joueur.pseudo;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            EnigmeForm enigmeForm = new EnigmeForm(service1, joueur1);
            enigmeForm.Show();
        }
    }
}
