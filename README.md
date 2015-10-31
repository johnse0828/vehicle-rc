# vehicle-rc

PARA EJECUTAR EN ECLIPSE

1. Clonar el repositorio o descargar el proyecto como zip en un directorio local
2. Descomprimir el zip
2. En eclipse:
	> Seleccionar el menú “File”
	> Seleccionar la opción “import”
	> Se debe seleccionar el tipo de proyecto que se va a importar, para ello: Seleccionar la 	categoría “Java” y la opción “Existing projects into workspace”, hacemos click 	en “Next”.
	> Se debe buscar el directorio del proyecto, para ello se hace click en el botón “Browse”, ubicamos la carpeta que descomprimimos y la seleccionamos.
	> Una vez seleccionada, eclipse nos mostrará una lista con los proyectos dentro de esta carpeta, para nuestro caso, únicamente nos mostrará un proyecto.
	> Se hace click en “Next” y el proyecto deberá ser cargado en Eclipse
	> Se hace click derecho en el proyecto y posteriormente click en “Run”

MODO DE USO
1. La aplicación pedirá el largo del campo de desplazamiento del vehículo, se debe ingresar un número entero positivo, de lo contrario, nos informará del error. Una vez se haya diligenciado el largo del campo, se nos pedirá el ancho del campo, que también debe ser un entero positivo.

2. La aplicación solicitará que empecemos a enviar comandos al vehículo, si el comando no es válido o está fuera del rango del campo del desplazamiento, nos informará del error. El formato para los comandos es <Desplazamiento>,<Dirección>. Si se desea enviar una lista de comandos, éstos se deben separar por “;”. Algunos ejemplos de comandos para un campo de 10x10 serían:
	3,N
	5,E
	2,N;1,O;2,S

URL DEL DIAGRAMA DE CLASES
https://cloud.githubusercontent.com/assets/5317115/10861666/c574dcea-7f56-11e5-9ca6-c9e1cbbd8859.png

DATOS DEL DESARROLLADOR
Nombre: John Sebastian Assa
