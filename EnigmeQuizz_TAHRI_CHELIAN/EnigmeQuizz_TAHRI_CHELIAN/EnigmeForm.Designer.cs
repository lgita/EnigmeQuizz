namespace EnigmeQuizz_TAHRI_CHELIAN
{
    partial class EnigmeForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(EnigmeForm));
            System.Windows.Forms.Label enigme1Label;
            this.enigmeBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.enigmeBindingNavigator = new System.Windows.Forms.BindingNavigator(this.components);
            this.bindingNavigatorMoveFirstItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMovePreviousItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorPositionItem = new System.Windows.Forms.ToolStripTextBox();
            this.bindingNavigatorCountItem = new System.Windows.Forms.ToolStripLabel();
            this.bindingNavigatorSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorMoveNextItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorMoveLastItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.bindingNavigatorAddNewItem = new System.Windows.Forms.ToolStripButton();
            this.bindingNavigatorDeleteItem = new System.Windows.Forms.ToolStripButton();
            this.enigmeBindingNavigatorSaveItem = new System.Windows.Forms.ToolStripButton();
            this.enigme1Label1 = new System.Windows.Forms.Label();
            enigme1Label = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.enigmeBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.enigmeBindingNavigator)).BeginInit();
            this.enigmeBindingNavigator.SuspendLayout();
            this.SuspendLayout();
            // 
            // enigmeBindingSource
            // 
            this.enigmeBindingSource.DataSource = typeof(EnigmeQuizz_TAHRI_CHELIAN.Enigme);
            // 
            // enigmeBindingNavigator
            // 
            this.enigmeBindingNavigator.AddNewItem = this.bindingNavigatorAddNewItem;
            this.enigmeBindingNavigator.BindingSource = this.enigmeBindingSource;
            this.enigmeBindingNavigator.CountItem = this.bindingNavigatorCountItem;
            this.enigmeBindingNavigator.DeleteItem = this.bindingNavigatorDeleteItem;
            this.enigmeBindingNavigator.ImageScalingSize = new System.Drawing.Size(24, 24);
            this.enigmeBindingNavigator.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.bindingNavigatorMoveFirstItem,
            this.bindingNavigatorMovePreviousItem,
            this.bindingNavigatorSeparator,
            this.bindingNavigatorPositionItem,
            this.bindingNavigatorCountItem,
            this.bindingNavigatorSeparator1,
            this.bindingNavigatorMoveNextItem,
            this.bindingNavigatorMoveLastItem,
            this.bindingNavigatorSeparator2,
            this.bindingNavigatorAddNewItem,
            this.bindingNavigatorDeleteItem,
            this.enigmeBindingNavigatorSaveItem});
            this.enigmeBindingNavigator.Location = new System.Drawing.Point(0, 0);
            this.enigmeBindingNavigator.MoveFirstItem = this.bindingNavigatorMoveFirstItem;
            this.enigmeBindingNavigator.MoveLastItem = this.bindingNavigatorMoveLastItem;
            this.enigmeBindingNavigator.MoveNextItem = this.bindingNavigatorMoveNextItem;
            this.enigmeBindingNavigator.MovePreviousItem = this.bindingNavigatorMovePreviousItem;
            this.enigmeBindingNavigator.Name = "enigmeBindingNavigator";
            this.enigmeBindingNavigator.PositionItem = this.bindingNavigatorPositionItem;
            this.enigmeBindingNavigator.Size = new System.Drawing.Size(800, 31);
            this.enigmeBindingNavigator.TabIndex = 0;
            this.enigmeBindingNavigator.Text = "bindingNavigator1";
            // 
            // bindingNavigatorMoveFirstItem
            // 
            this.bindingNavigatorMoveFirstItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveFirstItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveFirstItem.Image")));
            this.bindingNavigatorMoveFirstItem.Name = "bindingNavigatorMoveFirstItem";
            this.bindingNavigatorMoveFirstItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveFirstItem.Size = new System.Drawing.Size(28, 28);
            this.bindingNavigatorMoveFirstItem.Text = "Placer en premier";
            // 
            // bindingNavigatorMovePreviousItem
            // 
            this.bindingNavigatorMovePreviousItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMovePreviousItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMovePreviousItem.Image")));
            this.bindingNavigatorMovePreviousItem.Name = "bindingNavigatorMovePreviousItem";
            this.bindingNavigatorMovePreviousItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMovePreviousItem.Size = new System.Drawing.Size(28, 28);
            this.bindingNavigatorMovePreviousItem.Text = "Déplacer vers le haut";
            // 
            // bindingNavigatorSeparator
            // 
            this.bindingNavigatorSeparator.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator.Size = new System.Drawing.Size(6, 31);
            // 
            // bindingNavigatorPositionItem
            // 
            this.bindingNavigatorPositionItem.AccessibleName = "Position";
            this.bindingNavigatorPositionItem.AutoSize = false;
            this.bindingNavigatorPositionItem.Name = "bindingNavigatorPositionItem";
            this.bindingNavigatorPositionItem.Size = new System.Drawing.Size(50, 31);
            this.bindingNavigatorPositionItem.Text = "0";
            this.bindingNavigatorPositionItem.ToolTipText = "Position actuelle";
            // 
            // bindingNavigatorCountItem
            // 
            this.bindingNavigatorCountItem.Name = "bindingNavigatorCountItem";
            this.bindingNavigatorCountItem.Size = new System.Drawing.Size(57, 28);
            this.bindingNavigatorCountItem.Text = "de {0}";
            this.bindingNavigatorCountItem.ToolTipText = "Nombre total d\'éléments";
            // 
            // bindingNavigatorSeparator1
            // 
            this.bindingNavigatorSeparator1.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator1.Size = new System.Drawing.Size(6, 31);
            // 
            // bindingNavigatorMoveNextItem
            // 
            this.bindingNavigatorMoveNextItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveNextItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveNextItem.Image")));
            this.bindingNavigatorMoveNextItem.Name = "bindingNavigatorMoveNextItem";
            this.bindingNavigatorMoveNextItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveNextItem.Size = new System.Drawing.Size(28, 28);
            this.bindingNavigatorMoveNextItem.Text = "Déplacer vers le bas";
            // 
            // bindingNavigatorMoveLastItem
            // 
            this.bindingNavigatorMoveLastItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorMoveLastItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorMoveLastItem.Image")));
            this.bindingNavigatorMoveLastItem.Name = "bindingNavigatorMoveLastItem";
            this.bindingNavigatorMoveLastItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorMoveLastItem.Size = new System.Drawing.Size(28, 28);
            this.bindingNavigatorMoveLastItem.Text = "Placer en dernier";
            // 
            // bindingNavigatorSeparator2
            // 
            this.bindingNavigatorSeparator2.Name = "bindingNavigatorSeparator";
            this.bindingNavigatorSeparator2.Size = new System.Drawing.Size(6, 31);
            // 
            // bindingNavigatorAddNewItem
            // 
            this.bindingNavigatorAddNewItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorAddNewItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorAddNewItem.Image")));
            this.bindingNavigatorAddNewItem.Name = "bindingNavigatorAddNewItem";
            this.bindingNavigatorAddNewItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorAddNewItem.Size = new System.Drawing.Size(28, 28);
            this.bindingNavigatorAddNewItem.Text = "Ajouter nouveau";
            // 
            // bindingNavigatorDeleteItem
            // 
            this.bindingNavigatorDeleteItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.bindingNavigatorDeleteItem.Image = ((System.Drawing.Image)(resources.GetObject("bindingNavigatorDeleteItem.Image")));
            this.bindingNavigatorDeleteItem.Name = "bindingNavigatorDeleteItem";
            this.bindingNavigatorDeleteItem.RightToLeftAutoMirrorImage = true;
            this.bindingNavigatorDeleteItem.Size = new System.Drawing.Size(28, 28);
            this.bindingNavigatorDeleteItem.Text = "Supprimer";
            // 
            // enigmeBindingNavigatorSaveItem
            // 
            this.enigmeBindingNavigatorSaveItem.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.enigmeBindingNavigatorSaveItem.Enabled = false;
            this.enigmeBindingNavigatorSaveItem.Image = ((System.Drawing.Image)(resources.GetObject("enigmeBindingNavigatorSaveItem.Image")));
            this.enigmeBindingNavigatorSaveItem.Name = "enigmeBindingNavigatorSaveItem";
            this.enigmeBindingNavigatorSaveItem.Size = new System.Drawing.Size(28, 28);
            this.enigmeBindingNavigatorSaveItem.Text = "Enregistrer les données";
            // 
            // enigme1Label
            // 
            enigme1Label.AutoSize = true;
            enigme1Label.Location = new System.Drawing.Point(217, 67);
            enigme1Label.Name = "enigme1Label";
            enigme1Label.Size = new System.Drawing.Size(74, 20);
            enigme1Label.TabIndex = 1;
            enigme1Label.Text = "enigme1:";
            // 
            // enigme1Label1
            // 
            this.enigme1Label1.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.enigmeBindingSource, "enigme1", true));
            this.enigme1Label1.Location = new System.Drawing.Point(297, 67);
            this.enigme1Label1.Name = "enigme1Label1";
            this.enigme1Label1.Size = new System.Drawing.Size(100, 23);
            this.enigme1Label1.TabIndex = 2;
            this.enigme1Label1.Text = "label1";
            // 
            // EnigmeForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(enigme1Label);
            this.Controls.Add(this.enigme1Label1);
            this.Controls.Add(this.enigmeBindingNavigator);
            this.Name = "EnigmeForm";
            this.Text = "EnigmeForm";
            ((System.ComponentModel.ISupportInitialize)(this.enigmeBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.enigmeBindingNavigator)).EndInit();
            this.enigmeBindingNavigator.ResumeLayout(false);
            this.enigmeBindingNavigator.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.BindingSource enigmeBindingSource;
        private System.Windows.Forms.BindingNavigator enigmeBindingNavigator;
        private System.Windows.Forms.ToolStripButton bindingNavigatorAddNewItem;
        private System.Windows.Forms.ToolStripLabel bindingNavigatorCountItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorDeleteItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveFirstItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMovePreviousItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator;
        private System.Windows.Forms.ToolStripTextBox bindingNavigatorPositionItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator1;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveNextItem;
        private System.Windows.Forms.ToolStripButton bindingNavigatorMoveLastItem;
        private System.Windows.Forms.ToolStripSeparator bindingNavigatorSeparator2;
        private System.Windows.Forms.ToolStripButton enigmeBindingNavigatorSaveItem;
        private System.Windows.Forms.Label enigme1Label1;
    }
}