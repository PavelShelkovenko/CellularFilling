# Приложение - Тестовое задание в компанию "Сервис Руки" 

## Функционал приложения заключается в следующем:
  - равновероятно создается как живая, так и мёртвая клетка нажатием на кнопку "сотворить";
  - жизнь зарождается, если до этого трижды подряд создалась живая клетка;
  - если трижды подряд родилась мёртвая клетка, жизнь рядом умирает.


В проекте использовал [Jetpack Compose](https://developer.android.com/jetpack/compose) - для верстки UI слоя. Посчитал его более подходяющим инструментом для реализации несложного UI, так как пишется меньше шаблонного кода для создания списков. 

Решил немного "оживить" UI путем добавления анимации градиента на background-е



<img src="https://github.com/PavelShelkovenko/CellularFilling/blob/master/main_screen.gif" alt="App preview" width="360" height="840"/> <img src="https://github.com/PavelShelkovenko/CellularFilling/blob/master/creating_life.gif" alt="App preview" width="360" height="840"/>  <img src="https://github.com/PavelShelkovenko/CellularFilling/blob/master/death_of_life.gif" alt="App preview" width="360" height="840"/> 


