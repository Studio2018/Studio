int ledR = 11 ;
int ledG = 10;
int ledB = 9;

int trigpin = 5; //manda
int ecopin = 6; //recibe

long duracion, cm;
char val;

int mode = 3;

int ocupado = 0;

void setup() {
  Serial.begin(9600);
  pinMode(ledR, OUTPUT);
  pinMode(ledG, OUTPUT);
  pinMode(ledB, OUTPUT);

}

void loop() {

  pinMode(trigpin, OUTPUT);
  digitalWrite (trigpin, LOW);
  delayMicroseconds (2);
  digitalWrite (trigpin, HIGH);
  delayMicroseconds (10);

  pinMode (ecopin, INPUT);
  duracion = pulseIn (ecopin, HIGH);
  cm = (duracion / 2) / 29.1;

  if (cm > 50) {
    ocupado = 0;
    mode = 1;
  }

  if (cm <= 20) {
    ocupado = 1;
    mode = 2;
  }

  delay(100);

  if (mode == 0) { //apagado, modo de inicio
    digitalWrite (ledR, LOW);
    digitalWrite (ledG, LOW);
    digitalWrite (ledB, LOW);
  }

  if (mode == 1) { //modo no molestar
    digitalWrite (ledR, HIGH);
    digitalWrite (ledG, LOW);
    digitalWrite (ledB, LOW);
  }

  if (mode == 2) { //modo de pueden hablarme
    digitalWrite (ledR, LOW);
    digitalWrite (ledG, HIGH);
    digitalWrite (ledB, LOW);
  }

  if (mode == 3) { //modo de pausa o espera
    digitalWrite(ledR, LOW);
    digitalWrite(ledG, LOW);
    digitalWrite(ledB, HIGH);
  }
}

void serialEvent() {
  char estado[1];
  val = Serial.read();
  mode = estado [0];
  
  char msg[1];
  char  m = (char)ocupado;
  msg[0] = m;
  Serial.write(msg);

}
