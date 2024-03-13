import java.awt.image.BufferedImage;

public class Main {
        public class ImageConverter {
            private static final int MAX_WIDTH = 100;
            private static final int MAX_HEIGHT = 100;

            public BufferedImage convertImage(BufferedImage img) throws BadImageException {
                int width = img.getWidth();
                int height = img.getHeight();

                // Проверка на максимально допустимое соотношение сторон
                if (width > MAX_WIDTH || height > MAX_HEIGHT) {
                    throw new BadImageException("Изображение не соответствует максимально допустимому соотношению сторон.");
                }

                // Проверка на максимально допустимые ширину и высоту
                if (width > MAX_WIDTH || height > MAX_HEIGHT) {
                    double widthRatio = (double) MAX_WIDTH / width;
                    double heightRatio = (double) MAX_HEIGHT / height;
                    double minRatio = Math.min(widthRatio, heightRatio);

                    width = (int) (width * minRatio);
                    height = (int) (height * minRatio);
                }

                // Новый размер изображения с соблюдением пропорций
                BufferedImage resizedImage = new BufferedImage(width, height, img.getType());
                resizedImage.getGraphics().drawImage(img.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH), 0, 0, null);



                return resizedImage;
            }

            public static class BadImageException extends Exception {
                public BadImageException(String message) {
                    super(message);
                }
            }
        }

}
