# Forma de trabajar GitHub WorkFlow
## QUÉ ES UN COMMIT
Explicado de manera sencilla, es un punto donde guardas los cambios realizados. Un simil sería guardar partida en un videojuego, donde en cualquier momento puedes volver a ese punto de guardado.
## PROCESO
1. Cada persona tendrá asignados una seríe de issues.
2. Por cada Issue habrá que crear una rama, asegurate que parta de la rama de develop (1) y después dale a crear rama (2).
[![imagen-2024-01-27-140446851.png](https://i.postimg.cc/02V0fxfQ/imagen-2024-01-27-140446851.png)](https://postimg.cc/Czf8h39T)
Como puedes observar en la siguiente imagen te pedira que eligas la rama de la que partirá (3) y que Introduzcas el nombre de la ramma, a la cual le pondremos el nombre de nuestra Issue (4):
[![imagen-2024-01-27-140746252.png](https://i.postimg.cc/ydWHD7vZ/imagen-2024-01-27-140746252.png)](https://postimg.cc/tZ0ffG0q)
Trabajaremos sobre nuestra rama (Asegurate que estás en tú rama antes de empezar a hacer cambios)
[![imagen-2024-01-27-141224434.png](https://i.postimg.cc/Y0RYdc5M/imagen-2024-01-27-141224434.png)](https://postimg.cc/8fF7CYk0)

## Creación Commit
Cuando hayamos realizados los cambios pertinentes haremos un commit. Podemos observar (5) el numero de archivos cambiados. Además, es importante y obligatorio poner un nombre a nuestro commit (6), el mensaje (7) es opcional, pero es recomendable ponerlo. Una vez puesto lo anterior, le daremos al botton (8) y enviara el commit
[![imagen-2024-01-27-142348460.png](https://i.postimg.cc/ZqXH1ywn/imagen-2024-01-27-142348460.png)](https://postimg.cc/DWd1Gmk3)

Al hacer esto si la rama develop avanza y sigue trabajando gente con ella, podrías quedar desfasado/atrasado, Observa la siguiente imagen y como el issue#02 nunca llega a la rama Issue#03:
[![imagen-2024-01-27-145651021.png](https://i.postimg.cc/fbZDYB4j/imagen-2024-01-27-145651021.png)](https://postimg.cc/RWPkB1ZN)
Para solucionar este problema vamos a seguir los siguientes pasos haciendo merge (combinar) de la siguiente manera.

## Creación del Merge


Una vez creado el commit en nuestra rama Issue#numero. Nos iremos a la rama Develop(ASEGURATE que estés en DEVELOP) y le haremos fetch (Esto comprueba si hay cambios en la nube en GitHub).
[![imagen-2024-01-27-155416225.png](https://i.postimg.cc/B6S6BqgJ/imagen-2024-01-27-155416225.png)](https://postimg.cc/rdHM823H)
En el caso de que haya cambios (Estaremos desfasados) aparecerá lo siguiente, dejandonos hacer pull. Le daremos click
[![imagen-2024-01-27-154804757.png](https://i.postimg.cc/MZnKYrw2/imagen-2024-01-27-154804757.png)](https://postimg.cc/RqzBSdqX)

Nos ha podido pasar 2 cosas:
1. Existe algún tipo de cambio en la rama develop (Estamo desfasados con nuestra rama Issue)
2. No existe ningún tipo de cambio en la rama develop (Estamo al día)


### En el caso de que existan cambios en la rama develop (Estamo desfasados):
1. Volvemos a nuestra rama Issue#numero (1)
2. Mergeamos (2) desde nuestra Issue lo que hay en develop (3) y clicamos en crear commit del merge(4).
[![imagen-2024-01-27-151839972.png](https://i.postimg.cc/tT3vQQ28/imagen-2024-01-27-151839972.png)](https://postimg.cc/njLGB581)
[![imagen-2024-01-27-152040581.png](https://i.postimg.cc/cCmnNXqs/imagen-2024-01-27-152040581.png)](https://postimg.cc/H8rxw0sK)
3. En el caso de haber algún tipo de conflicto, lo tendreis que solucionar, seleccionando la parte funcional/nueva y borrando la parte no funcional/antigua. Un ejemplo de conflicto:
[![conflicto-con-git-merge.png](https://styde.net/wp-content/uploads/2015/10/conflicto-con-git-merge.png)](https://styde.net/wp-content/uploads/2015/10/conflicto-con-git-merge.png)
4. Una vez realizado el merge con exito, ya estaremos al día con la rama develop, realizaremos todos los test para ver que no hay ningún tipo de problema.
5. Si todo está correcto, nos iremos a develop (5) y mergearemos nuestra rama Issue(7) y por ultimo crearemos el merge commit (8).
[![imagen-2024-01-27-153036368.png](https://i.postimg.cc/1XMwhP2C/imagen-2024-01-27-153036368.png)](https://postimg.cc/QK9HcLX1)
[![imagen-2024-01-27-153200822.png](https://i.postimg.cc/jC05F1dg/imagen-2024-01-27-153200822.png)](https://postimg.cc/301YynGm)
6. Por ultimo haremos push en la rama.
[![imagen-2024-01-27-154032047.png](https://i.postimg.cc/mgv6XfMf/imagen-2024-01-27-154032047.png)](https://postimg.cc/0zCfj4cc)

### En el caso de que NO existean cambios en la rama develop (Estemos al día):
Es decir, que nuestra rama Issue no esté desfasada con la de develop, seguiriamos los pasos de "En el caso de que existan cambios en la rama develop", pero a partir del punto 4 (incluyendolo).