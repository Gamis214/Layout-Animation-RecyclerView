# Layout Animation RecyclerView
Uso de componente LayoutAnimator para animar los items cada que se inicializa una lista.

### Referencia
[Enter animation using RecyclerView and LayoutAnimation](https://proandroiddev.com/enter-animation-using-recyclerview-and-layoutanimation-part-1-list-75a874a5d213)

## Instruciones
Para poder usar esta herramienta primero debemos generar nuestra animacion:
* Fall Down
```xml
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="500">

    <translate
        android:fromYDelta="-20%"
        android:toYDelta="0"
        android:interpolator="@android:anim/decelerate_interpolator"
        />

    <alpha
        android:fromAlpha="0"
        android:toAlpha="1"
        android:interpolator="@android:anim/decelerate_interpolator"
        />

    <scale
        android:fromXScale="105%"
        android:fromYScale="105%"
        android:toXScale="100%"
        android:toYScale="100%"
        android:pivotX="50%"
        android:pivotY="50%"
        android:interpolator="@android:anim/decelerate_interpolator"
        />

</set>
```
A continuacion generamos nuestro LayoutAnimation
```xml
<?xml version="1.0" encoding="utf-8"?>
<layoutAnimation
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:animation="@anim/item_animation_fall_down"
    android:delay="15%"
    android:animationOrder="normal"    
/>
```
Una vez generado los dos archivos dentro de la carpeta **Anim** construimos nuestra lista con un Adaptador Custom y por medio del siguiente
codigo agregamos la animacion a nuestros elementos de la lista:
```java
LayoutAnimationController animationController =
                AnimationUtils.loadLayoutAnimation(this,R.anim.layoutAnimationFallDown);

myList.setLayoutAnimation(animationController);
```
