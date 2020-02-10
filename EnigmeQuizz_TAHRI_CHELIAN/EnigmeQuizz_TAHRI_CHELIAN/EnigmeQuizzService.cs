using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EnigmeQuizz_TAHRI_CHELIAN
{
    public class EnigmeQuizzService
    {
        EnigmeQuizz_TAHRI_CHELIAN_BDDEntities minisjeuxEntities = new EnigmeQuizz_TAHRI_CHELIAN_BDDEntities();

        /// <summary>
        /// Initilisation de la liste de reponses aux quizz
        /// </summary>
        /// <returns></returns>
        public List<ReponseQuizz> InitListeReponseQuizz()
        {
            return minisjeuxEntities.ReponseQuizz.ToList();

        }

        /// <summary>
        /// Initialisation de la liste de questions aux quizz
        /// </summary>
        /// <returns></returns>
        public List<QuestionQuizz> InitListeQuestionsQuizz()
        {
            return minisjeuxEntities.QuestionQuizz.ToList();

        }

        /// <summary>
        /// Initialisation de la liste d'enigmes
        /// </summary>
        /// <returns></returns>
        public List<Enigme> InitListeEnigme()
        {
            return minisjeuxEntities.Enigme.ToList();

        }

        /// <summary>
        /// Initialisation de la liste de quizz
        /// </summary>
        /// <returns></returns>
        public List<Quizz> InitListeQuizz()
        {
            return minisjeuxEntities.Quizz.ToList();

        }


        /// <summary>
        /// Initialisation de la liste des joueurs
        /// </summary>
        /// <returns></returns>
        public List<Joueur> InitListeJoueur()
        {
            return minisjeuxEntities.Joueur.ToList();

        }


        /// <summary>
        /// Méthode permettant de créer une réponse qui est lié à une question
        /// </summary>
        /// <param name="reponse">Reponse lié à la question</param>
        /// <param name="questionlie">Récupération de la question lié</param>

       /* public void CreationReponseQuizz(String reponse, QuestionQuizz questionlie)
        {
            ReponseQuizz rquizz = new ReponseQuizz();
            rquizz.reponseQuizz1 = reponse;
            rquizz.QuestionQuizz = questionlie;
            minisjeuxEntities.ReponseQuizz.Add(rquizz);
            minisjeuxEntities.SaveChanges();
        }
        /// <summary>
        /// Méthode permettant de créer une question qui est lié à un quizz
        /// </summary>
        /// <param name="question">Question lié au quizz</param>
        /// <param name="quizzlie">Quizz qui est lié</param>

        public void CreationQuestionsQuizz(String question, Quizz quizzlie)
        {
            QuestionQuizz qquizz = new QuestionQuizz();
            qquizz.questionQuizz1 = question;
            qquizz.Quizz = quizzlie;
            minisjeuxEntities.QuestionQuizz.Add(qquizz);
            minisjeuxEntities.SaveChanges();

        }*/
        /// <summary>
        /// Méthode permettant de créer un quizz
        /// </summary>
        /// <param name="theme">Thème du quizz</param>

        public void CreationQuizz(String theme)
        {
            Quizz quizz = new Quizz();
            quizz.theme = theme;
            minisjeuxEntities.Quizz.Add(quizz);
            minisjeuxEntities.SaveChanges();
        }

        /// <summary>
        /// Méthode permettant de créer une enigme
        /// </summary>
        /// <param name="enigme">Enigme</param>
        /// <param name="reponseEnigme">Réponse de l'enigme</param>
        /// 
        public void CreationEnigme(String enigme, String reponseEnigme)
        {
            Enigme engme = new Enigme();
            engme.enigme1 = enigme;
            engme.reponseEnigme = reponseEnigme;
            minisjeuxEntities.Enigme.Add(engme);
            minisjeuxEntities.SaveChanges();
        }

        /// <summary>
        /// Méthode permettant de créer un joueur
        /// </summary>
        /// <param name="pseudo">Pseudo unique entré à la création du joueur</param>
        /// <param name="mdp">Mot de passe lié à la création</param>

        public Joueur CreationJoueur(String pseudo, String mdp)
        {
            Joueur joueur = new Joueur();
            joueur.pseudo = pseudo;
            joueur.mdp = mdp;
            joueur.scoreJoueur = 0;
            minisjeuxEntities.Joueur.Add(joueur);
            minisjeuxEntities.SaveChanges();
            return joueur;
        }

        /// <summary>
        /// Méthode permettant de recherche un quizz par thème
        /// </summary>
        /// <param name="theme">Theme du quizz recherché</param>
        /// <returns></returns>
        public List<Quizz> RechercherQuizzTheme(String theme)
        {
            List<Quizz> listeQuizz = null;

            var requeteQuizz = from Quizz in InitListeQuizz()
                               where Quizz.theme == theme
                               select Quizz;

            listeQuizz = requeteQuizz.ToList();
            return listeQuizz;

        }

        /// <summary>
        /// Rechercher le theme d'un quizz
        /// </summary>
        /// <returns></returns>
        public List<String> QuizzTheme()
        {
            List<String> listeQuizz = null;

            var requeteQuizz = from Quizz in InitListeQuizz()
                               select Quizz.theme;

            listeQuizz = requeteQuizz.ToList();
            
            return listeQuizz;

        }


        /// <summary>
        /// Rechercher un score par Joueur
        /// </summary>
        /// <param name="joueur">Joueur dont on cherche le score</param>
        /// <returns></returns>
        public int RechercherScoreJoueur(Joueur joueur)
        {

            Joueur jr = new Joueur();

            int idjoueur = joueur.Id_joueur;
            var requeteScoreJoueur = from Joueur in InitListeJoueur()
                                     where Joueur.Id_joueur == idjoueur
                                     select Joueur;

            jr = requeteScoreJoueur.Single();
            int score = Convert.ToInt32(jr.scoreJoueur);
            return score;


        }
        /// <summary>
        /// Verifier si l'enigme est correcte ou non 
        /// </summary>
        /// <param name="reponseEnigmeJoueur"></param>
        /// <param name="enigme"></param>
        /// <returns></returns>
        public Boolean EnigmeCorrecte(String reponseEnigmeJoueur, Enigme enigme)
        {
            Boolean repEnigme;
            repEnigme = false;

            if (reponseEnigmeJoueur == enigme.reponseEnigme)
            {
                repEnigme = true;
            }
            else
            {
                repEnigme = false;
            }
            return repEnigme;
        }

        /// <summary>
        /// Verifier si le quizz est correct ou non 
        /// </summary>
        /// <param name="reponseQuizzJoueur"></param>
        /// <param name="quizz"></param>
        /// <param name="reponseQuizz"></param>
        /// <returns></returns>
        public Boolean QuizzCorrect(String reponseQuizzJoueur, Quizz quizz, ReponseQuizz reponseQuizz)
        {
            Boolean repQuizz;
            repQuizz = false;


            //String reponseChoisie = ;

            //A MODIFIER
            if (reponseQuizzJoueur.Equals(reponseQuizz.reponseQuizz1))
            {
                repQuizz = true;
            }
            else
            {
                repQuizz = false;
            }
            return repQuizz;
        }
    




        /// <summary>
        /// Methode d'authentification du joueur
        /// </summary>
        /// <param name="pseudo">Pseudo recherche en base et compare a celui en parametre</param>
        /// <param name="mdp">Mdp recherche en base et compare a celui en parametre</param>
        /// <returns></returns>
        public Joueur AuthentificationJoueur(String pseudo, String mdp)
        {
            Joueur jr = new Joueur();

            var requeteJoueur = from Joueur in InitListeJoueur()
                                where Joueur.pseudo == pseudo
                                where Joueur.mdp == mdp
                                select Joueur;


            jr = requeteJoueur.Single();
            return jr;

        }

        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public int nombreEnigme()
        {
            Enigme enigme = new Enigme();

            var requeteEnigme = from Enigme in InitListeEnigme()
                                select Enigme;

            List<Enigme> enigmes = requeteEnigme.ToList();

            int element = enigmes.Count;
            
            return element;

        }

        /// <summary>
        /// Methode permettant de retourner une enigme au hasard
        /// </summary>
        /// <returns></returns>
        public Enigme EnigmechoisiauHasard()
        {
            int nombremax = nombreEnigme();

            Random aleatoire = new Random();
            int idChoisiAuHasard = aleatoire.Next(nombremax);

            Enigme enigme = new Enigme();

            var requeteEnigme = from Enigme in InitListeEnigme()
                                where Enigme.Id_enigme == idChoisiAuHasard
                                select Enigme;


            Enigme enigmechoisi = requeteEnigme.Single();

            return enigmechoisi;

        }

        /// <summary>
        /// Methode permettant de rechercher une enigme par corps d'engime
        /// </summary>
        /// <param name="corpsdelenigme"></param>
        /// <returns></returns>
        public Enigme RechercheEnigme(string corpsdelenigme)
        {
            Enigme enigme = new Enigme();

            var requeteEnigme = from Enigme in InitListeEnigme()
                                where Enigme.enigme1 == corpsdelenigme
                                select Enigme;


            enigme = requeteEnigme.Single();
            return enigme;

        }

        /// <summary>
        /// Methode permettant de modifier le score du joueur
        /// </summary>
        /// <param name="joueur"></param>
        /// <param name="nouveauscore"></param>
        /// <returns></returns>
        public int modificationScore(Joueur joueur, int nouveauscore)
        {
            joueur.scoreJoueur = nouveauscore;
            minisjeuxEntities.SaveChanges();
            return (int) joueur.scoreJoueur;

        }

        /// <summary>
        /// Methode permettant de rechercher un quizz par theme
        /// </summary>
        /// <param name="theme"></param>
        /// <returns></returns>
        public List<QuestionQuizz> QuestionQuizzpartheme(string theme)
        {
            List<QuestionQuizz> questionQuizzs = new List<QuestionQuizz>();
            

            var requeteQuestionq = from QuestionQuizz in InitListeQuestionsQuizz()
                                where QuestionQuizz.Quizz1.theme == theme
                                select QuestionQuizz;


            questionQuizzs = requeteQuestionq.ToList();
            return questionQuizzs;

        }
    }
}
