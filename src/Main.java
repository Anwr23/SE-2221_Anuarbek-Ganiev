import java.util.ArrayList;
import java.util.List;

// Singleton
class VideoCreator {
    private static VideoCreator instance;

    private VideoCreator() {}

    public static VideoCreator getInstance() {
        if (instance == null) {
            instance = new VideoCreator();
        }
        return instance;
    }

    // Factory Method
    public Video createVideo(VideoFactory factory) {
        return factory.createVideo();
    }

    // Observer
    private List<VideoCreationObserver> observers = new ArrayList<>();

    public void addObserver(VideoCreationObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(VideoCreationObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(Video video) {
        for (VideoCreationObserver observer : observers) {
            observer.update(video);
        }
    }

    // Builder
    public VideoBuilder getVideoBuilder() {
        return new VideoBuilder();
    }

    // Strategy
    private VideoCreationStrategy strategy;

    public void setCreationStrategy(VideoCreationStrategy strategy) {
        this.strategy = strategy;
    }

    public void createVideoWithStrategy() {
        if (strategy != null) {
            strategy.applyStrategy();
        }
    }

    // Abstract Factory
    private VideoComponentFactory componentFactory;

    public void setComponentFactory(VideoComponentFactory componentFactory) {
        this.componentFactory = componentFactory;
    }

    public VideoComponentFactory getComponentFactory() {
        return componentFactory;
    }

    // Отправка уведомления об успешном создании
    public void sendNotification(Video video) {
        System.out.println("Notification: Video successfully created - " + video.getTitle());
        notifyObservers(video);
    }
}

// Factory Method
interface VideoFactory {
    Video createVideo();
}

class ConcreteVideoFactory implements VideoFactory {
    @Override
    public Video createVideo() {
        return new ConcreteVideo();
    }
}

// Observer
interface VideoCreationObserver {
    void update(Video video);
}

class NotificationService implements VideoCreationObserver {
    @Override
    public void update(Video video) {
        System.out.println("Notification: New video available - " + video.getTitle());
    }
}

// Builder
class VideoBuilder {
    private String title;
    private String description;

    public VideoBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public VideoBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Video build() {
        return new Video() {
            @Override
            public String getTitle() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }
        };
    }
}

// Strategy
interface VideoCreationStrategy {
    void applyStrategy();
}

class MontageStrategy implements VideoCreationStrategy {
    @Override
    public void applyStrategy() {
        System.out.println("Applying Montage Strategy");
    }
}

// Abstract Factory
interface VideoComponentFactory {
    String createText();
    String createMusic();
}

class DefaultVideoComponentFactory implements VideoComponentFactory {
    @Override
    public String createText() {
        return "Default text";
    }

    @Override
    public String createMusic() {
        return "Default music";
    }
}

class SpecialVideoComponentFactory implements VideoComponentFactory {
    @Override
    public String createText() {
        return "Special text";
    }

    @Override
    public String createMusic() {
        return "Special music";
    }
}

class ConcreteVideo implements Video {
    private String title;
    private String description;

    public ConcreteVideo() {
        // Default constructor
    }

    public ConcreteVideo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
}

// Интерфейс для Video
interface Video {
    String getTitle();
    String getDescription();
}

public class Main {
    public static void main(String[] args) {
        // Singleton
        VideoCreator videoCreator = VideoCreator.getInstance();

        // Factory Method
        VideoFactory videoFactory = new ConcreteVideoFactory();
        Video video = videoCreator.createVideo(videoFactory);

        // Observer
        VideoCreationObserver notificationService = new NotificationService();
        videoCreator.addObserver(notificationService);

        // Builder
        VideoBuilder videoBuilder = videoCreator.getVideoBuilder();
        videoBuilder.setTitle("Awesome Video");
        videoBuilder.setDescription("This is an awesome video");
        Video builtVideo = videoBuilder.build();

        // Strategy
        VideoCreationStrategy montageStrategy = new MontageStrategy();
        videoCreator.setCreationStrategy(montageStrategy);
        videoCreator.createVideoWithStrategy();

        // Abstract Factory
        VideoComponentFactory componentFactory = new SpecialVideoComponentFactory();
        videoCreator.setComponentFactory(componentFactory);

        // Отправка уведомления об успешном создании
        videoCreator.sendNotification(video);
        videoCreator.sendNotification(builtVideo);
    }
}
