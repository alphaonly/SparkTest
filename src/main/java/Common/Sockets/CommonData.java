package Common.Sockets;

  public  class CommonData {
      private static String serverHost = "10.42.0.1";
     private static int serverPort = 6001;

      public static String getServerHost() {
          return serverHost;
      }



     public static int getServerPort(){

         return serverPort;
     }
}