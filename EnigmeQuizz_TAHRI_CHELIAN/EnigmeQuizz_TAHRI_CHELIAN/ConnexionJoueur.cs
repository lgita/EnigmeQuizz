﻿using System;
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
    public partial class ConnexionJoueur : Form
    {

        EnigmeQuizzService service1;

        public ConnexionJoueur(EnigmeQuizzService service)
        {
            InitializeComponent();
            service1 = service;
           

        }

        private void button1_Click(object sender, EventArgs e)
        {
            String pseudo = textBox1.Text;
            String mdp = textBox2.Text;
            Joueur joueurliee = service1.AuthentificationJoueur(pseudo, mdp);
            MenuGeneral menuGeneral = new MenuGeneral(service1, joueurliee);
            menuGeneral.Show();
            this.Visible = false;
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }
    }
}
