package de.solarbank.live

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent { MaterialTheme { App() } }
 }
}
@Composable fun App() {
 var dashboard by remember { mutableStateOf(false) }
 var email by remember { mutableStateOf("") }
 var password by remember { mutableStateOf("") }
 Surface(Modifier.fillMaxSize()) {
  if (!dashboard) Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement=Arrangement.Center) {
   Text("Solarbank Live", style=MaterialTheme.typography.headlineLarge)
   Text("Anker SOLIX Solarbank 3 E2700 Pro")
   Spacer(Modifier.height(24.dp))
   OutlinedTextField(email,{email=it},label={Text("Anker E-Mail")},modifier=Modifier.fillMaxWidth())
   Spacer(Modifier.height(12.dp))
   OutlinedTextField(password,{password=it},label={Text("Passwort")},visualTransformation=PasswordVisualTransformation(),modifier=Modifier.fillMaxWidth())
   Spacer(Modifier.height(18.dp))
   Button({if(email.isNotBlank()&&password.isNotBlank()) dashboard=true},Modifier.fillMaxWidth()){Text("Dashboard öffnen")}
   Spacer(Modifier.height(12.dp))
   Text("Noch keine echte Anker-Anmeldung. Zugangsdaten werden nicht gespeichert oder übertragen.",style=MaterialTheme.typography.bodySmall)
  } else Column(Modifier.fillMaxSize().padding(20.dp)) {
   Text("Solarbank Live",style=MaterialTheme.typography.headlineMedium)
   Text("Anker SOLIX Solarbank 3 E2700 Pro")
   Spacer(Modifier.height(24.dp))
   Text("☀ PV  →  🔋 Akku  →  🏠 Haus  →  ⚡ Netz",style=MaterialTheme.typography.titleLarge)
   Spacer(Modifier.height(18.dp))
   Card(Modifier.fillMaxWidth()){Column(Modifier.padding(18.dp)){Text("Live-Leistung");Text("PV     — W");Text("Haus   — W");Text("Akku   — W");Text("Netz   — W")}}
   Spacer(Modifier.height(14.dp))
   Card(Modifier.fillMaxWidth()){Column(Modifier.padding(18.dp)){Text("Batterie");Text("Ladezustand  — %")}}
   Spacer(Modifier.height(14.dp))
   Text("MPPT 1  — W     MPPT 2  — W"); Text("MPPT 3  — W     MPPT 4  — W")
   Spacer(Modifier.height(20.dp)); Text("Heute   •   Woche   •   Monat   •   Jahr")
   Spacer(Modifier.height(10.dp)); Text("Live-Daten folgen nach echter Anker-Schnittstellenanbindung.",style=MaterialTheme.typography.bodySmall)
  }
 }
}
