package Observable;

import Observer.IObserver;

public interface IObservable {

   public void addObserver(IObserver observer);
   public void deleteObserver(IObserver observer);
   public void notifyObserver();

}
