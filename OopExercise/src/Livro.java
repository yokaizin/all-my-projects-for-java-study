public class Livro implements Manuseio{

   private String titulo;
   private String autor;
   private int totalPg;
   private int pagAtual;
   private boolean aberto;
   private Pessoa leitor;


   private boolean ocupado;



    public Livro(String ttl, String at, int tpg) {
        setTitulo(ttl);
        setAutor(at);
        setTotalPg(tpg);
        setAberto(false);
        this.pagAtual = 0;
    }


    public String detalhes() {

        String nomeLeitor;

        if (this.leitor == null){
            nomeLeitor = "Nenhum";

        }else {
            nomeLeitor = this.leitor.getNome();
        }

        return "----------------------------------------------" + "\nLivro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", totalPg=" + totalPg +
                ", pagAtual=" + pagAtual +
                ", aberto=" + aberto +
                ", leitor=" + nomeLeitor +
                '}';
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String ttl) {
        this.titulo = ttl;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String at) {
        this.autor = at;
    }

    public int getTotalPg() {
        return totalPg;
    }

    public void setTotalPg(int tpg) {
        this.totalPg = tpg;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    private void setPagAtual(int pga) {
        this.pagAtual = pga;
    }

    public boolean isAberto() {
        return aberto;
    }

    private void setAberto(boolean ab) {
        this.aberto = ab;
    }

    public Pessoa getLeitor() {
        return leitor;
    }

    public void setLeitor(Pessoa lt) {
        this.leitor = lt;

    }

    @Override
    public void abrir() {
        System.out.println("----------------------------------------------");
        if(!isAberto()) {
            setAberto(true);
            System.out.println("Abrindo livro...");
        } else {
            System.out.println("O livro j?? est?? aberto !");
        }
    }

    @Override
    public void fechar() {
        System.out.println("----------------------------------------------");
        if (isAberto()){
            setAberto(false);
            System.out.println("Fechando Livro...");
        }else {
            System.out.println("O livro j?? est?? fechado !");
        }

    }

    @Override
    public void folhear() {
        System.out.println("folheando o livro");
    }

    @Override
    public void avancarPag() {
        System.out.println("----------------------------------------------");
        if (isAberto()) {
            if (getPagAtual() < getTotalPg()) {

                System.out.println("Avan??ando uma p??gina");
                this.setPagAtual(getPagAtual() + 1);
                System.out.println("Pagina atual: " + getPagAtual());

            } else {

                System.out.println("Voc?? ja est?? na ultima pagina !");
            }
        }else {
            System.out.println("N??o ?? possivel mudar de pagina sem abrir o livro");
        }
    }

    @Override
    public void voltarPag() {
        System.out.println("----------------------------------------------");
        if (isAberto()) {
            if (getPagAtual() > 0) {


                System.out.println("Voltando uma p??gina !");
                this.setPagAtual(getPagAtual() - 1);
                System.out.println("Pagina atual: " + getPagAtual());

            } else {

                System.out.println("Voc?? ja est?? na pagina inicial !");
            }
        }else {
            System.out.println("N??o ?? possivel mudar de pagina sem abrir o livro");
        }


    }

    @Override
    public void pegarParaLer(Pessoa ps) {
        System.out.println("----------------------------------------------");
        if ((!ps.isLendo()) && (!this.ocupado)){
            System.out.println("Pegando " + this.titulo + " para ler");
            ps.setLendo(true);
            setOcupado(true);
            setLeitor(ps);
            setAberto(false);
        }else if (ps.isLendo()){
            System.out.println("Voc?? n??o pode pegar um livro pois j?? esta lendo outro");
        }else if (this.ocupado) {
            System.out.println("Esse livro est?? indispon??vel, pois est?? sendo lido por outra pessoa");
        }
    }


    @Override
    public void devolver(Pessoa ps) {
        System.out.println("----------------------------------------------");
        if (ps == leitor){

            System.out.println("Devolvendo livro...");
            ps.setLendo(false);
            setOcupado(false);
            setLeitor(null);
            setPagAtual(0);
            setAberto(false);
        } else {

            System.out.println("Voc?? n??o pode devolver o livro, pois n??o est?? com ele");

        }
    }
}
