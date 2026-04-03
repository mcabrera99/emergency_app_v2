package com.example.emergenciav2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emergenciav2.ui.theme.Emergenciav2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Emergenciav2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Pantalla(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TextoNegrita(text:String){
    Text(text, fontWeight= FontWeight.Bold, color= Color.Black)
}

@Composable
fun Texto(text:String){
    Text(text, color= Color.Black)
}

@Composable
fun Aviso(titulo : String , descripcion : String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top= 10.dp , start=10.dp , end=10.dp)
        .border(2.dp,Color.Gray)
    ){
        Column(modifier = Modifier
            .background(color=Color.White)
            .fillMaxWidth()
            .padding(start=10.dp,top=5.dp,end=10.dp,bottom=5.dp)
        ){
            TextoNegrita(titulo)
            Texto(descripcion)
        }
    }
}



@Composable
fun Pantalla(modifier : Modifier = Modifier){

    var enviarUbicacion by remember{mutableStateOf(false)}
    var alarma by remember{mutableStateOf(false)}
    var lat by remember{mutableStateOf("-30.563214")}
    var lon by remember{mutableStateOf("-64.422658")}
    var acc by remember{mutableStateOf("15")}

    Column(modifier = Modifier.background(color=Color.White).fillMaxSize()){
        Row(modifier = Modifier.fillMaxWidth().padding(top=30.dp,start=15.dp,end=15.dp,bottom=15.dp).height(130.dp),
            horizontalArrangement = Arrangement.SpaceBetween){
            Column(modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center){
                Texto(text="GPS activado")
                Texto(text= "Latitud: $lat")
                Texto(text="Longitud: $lon")
                Texto(text="Precisión: $acc m")
            }
            Image(painter=painterResource( R.drawable.mapita ),
                contentDescription = "Mapa",
                modifier = Modifier.height(120.dp).width(120.dp).border(2.dp,Color.Gray)
                )
        }

        Spacer(modifier = Modifier.height(5.dp).background(color=Color.Gray).fillMaxWidth())

        Row(modifier = Modifier.fillMaxWidth().padding(15.dp).height(130.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            var locationChecked by remember { mutableStateOf(false)}
            Image(painter = painterResource(R.drawable.pin),
                contentDescription = "Pin")
            TextoNegrita("Compartir ubicación \nen tiempo real con el \nCentro de Comando")
            Switch(checked = locationChecked , onCheckedChange={it -> locationChecked = it})
        }

        Spacer(modifier = Modifier.height(5.dp).background(color=Color.Gray).fillMaxWidth())

        Row(modifier = Modifier.fillMaxWidth().padding(15.dp).height(130.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround){
            var alarmChecked by remember { mutableStateOf(false)}
            Image(painter=painterResource(R.drawable.sirena), contentDescription = "Sirena")
            TextoNegrita(text="Enviar alerta al \nCentro de Comando")
            Switch(checked = alarmChecked , onCheckedChange={it -> alarmChecked = it})
        }

        Spacer(modifier = Modifier.height(5.dp).background(color=Color.Gray).fillMaxWidth())

        Row(modifier = Modifier.fillMaxSize().padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround){
            Column(){
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center){
                    TextoNegrita("AVISOS DESDE EL CENTRO DE COMANDO")
                }
                Row(modifier = Modifier.fillMaxSize()){
                    val scrollState = rememberScrollState()
                    Column(modifier = Modifier.fillMaxSize().background(color=Color.LightGray).border(2.dp,Color.Gray).verticalScroll(scrollState)){
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                        Aviso("Regresar urgente", "Altos niveles de radiación")
                    }
                }

            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Emergenciav2Theme {
        Pantalla()
    }
}