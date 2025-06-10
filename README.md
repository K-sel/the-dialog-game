# TheDialogGame

TheDialogGame est un jeu d'aventure textuel que j'ai développé en tant que projet personnel. Ce projet met l'accent sur les principes de la programmation orientée objet (POO) et intègre des modèles de conception pour créer une expérience de jeu modulaire et extensible.

Dans ce jeu, les joueurs explorent une carte dynamique, débloquent de nouvelles zones en résolvant des énigmes, collectionnent et interagissent avec des objets, et progressent à travers un voyage riche en narration.

## Fonctionnalités

### Gameplay

	•	Explorer la Carte : Voyagez à travers des zones interconnectées, débloquant de nouveaux territoires en résolvant des énigmes et en progressant dans l'histoire.
	•	Interagir avec les Objets : Ramassez, inspectez, déposez ou utilisez des objets pour résoudre des défis et avancer.
	•	Résoudre des Énigmes : Engagez-vous avec des devinettes et des indices pour débloquer de nouvelles zones et percer des mystères.
	•	Interface Basée sur les Commandes : Tapez des commandes comme aller, prendre, inspecter ou résoudre pour interagir avec le monde du jeu.

### Points Techniques Saillants

	•	Conception Orientée Objet : Conception modulaire utilisant l'encapsulation, l'héritage et le polymorphisme.
	•	Modèles de Conception :
	•	Modèle Factory : Pour créer dynamiquement des objets de jeu (par exemple, zones, énigmes ou objets).
	•	Modèle Singleton : Pour gérer l'état du jeu et les données du joueur.
	•	Modèle Strategy : Pour implémenter différents mécanismes de résolution d'énigmes.
	•	Système de Saisie Textuel : Système de commandes intuitif avec des retours clairs pour guider le joueur.


## Exemple de Gameplay

<img width="738" alt="gameplay-exemple" src="https://github.com/user-attachments/assets/654946ee-2139-4336-98be-ec37d31064b4">


## Commandes Disponibles

| Commande | Description | Utilisation | Variante |
|----------|-------------|-------------|----------|
| **Drop** | Retire des objets de votre inventaire | Quand vous voulez retirer un objet de votre inventaire. Il tombe au sol mais ne disparaît pas | `drop all` retire tous les objets |
| **Help** | Liste toutes les commandes disponibles dans le jeu | Quand vous ne vous souvenez plus de quoi faire ou voulez vérifier les interactions disponibles | - |
| **Take** | Ramasse des objets qui peuvent être collectés | Quand vous trouvez un objet qui semble important, gardez-le ! Il pourrait être utile plus tard | `take all` collecte tous les objets récupérables |
| **Read** | Lit les lettres trouvées | Pour lire une lettre qui pourrait contenir des indices importants | - |
| **Solve** | Résout des énigmes | Quand vous voulez soumettre une réponse à une énigme | - |
| **Go** | Déplace le joueur sur la carte | Pour voyager avec quatre options de mouvement (Nord/Sud/Est/Ouest) | - |
| **Inspect** | Inspecte des objets | Pour inspecter les objets qui pourraient contenir des indices précieux | - |
| **Quit** | Quitte le jeu | Pour quitter le jeu (Attention : pas de sauvegarde) | - |
| **Inventory** | Affiche le contenu de l'inventaire | Quand vous voulez vérifier ce qui se trouve dans votre inventaire et l'espace restant | - |
| **Map** | Affiche la carte du jeu | Si vous êtes perdu, aide à s'orienter. Position actuelle en vert, zones verrouillées en gris | - |
| **Look** | Observe et identifie les objets dans la zone | Quand vous arrivez dans une nouvelle zone pour avoir un aperçu des objets alentour | - |
| **Open** | Ouvre des coffres ou zones verrouillées | À condition d'avoir les bonnes clés dans votre inventaire | - |  


## Comment Exécuter

	1.	Clonez le dépôt, obtenez le code :

	2.	Compilez les fichiers Java :

	3.	Lancez le jeu :


## Apprentissages

Ce projet a servi d'application pratique des concepts POO et des modèles de conception dans un scénario réel. Il m'a permis de réfléchir de manière critique à la conception de jeux, à la modularité et à l'évolutivité. J'ai pris beaucoup de plaisir à développer ce projet, le gameplay n'est pas complètement terminé mais toute l'infrastructure est là, n'hésitez pas à cloner et créer votre propre gameplay.


## Retours

Si vous avez des suggestions pour améliorer les mécaniques de jeu, le système de commandes ou la structure du code, n'hésitez pas à ouvrir une issue ou à soumettre une pull request !
