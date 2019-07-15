package cashregister;

class FakePrinter extends Printer{
    private boolean isCalled=false;
    private String text;

    public void print(String output) {
        text = output;
        isCalled = true;
    }

    public boolean printMethodWasCalled(){
        return isCalled;
    }

    public String printedString(){
        return text;
    }
}
