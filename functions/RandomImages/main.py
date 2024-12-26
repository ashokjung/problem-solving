import functions_framework
from google.cloud import storage
from google.cloud import exceptions
import random
import base64

BUCKET_NAME = "gcs-bucket-images"
IMAGE_NAMES = ["images01.jpeg", "images02.jpeg", "images03.jpeg","images04.jpeg","images05.jpeg","images06.jpeg","images07.jpeg"]

# Initialize GCS client outside the function for reuse
storage_client = storage.Client()


@functions_framework.http
def hello_http(request):
    try:
        # Pick a random image from the predefined list
        random_image_name = random.choice(IMAGE_NAMES)
        blob = storage_client.bucket(BUCKET_NAME).blob(random_image_name)

        # Download the image content
        image_content = blob.download_as_bytes()

        # Encode image content to base64 for embedding
        encoded_image = base64.b64encode(image_content).decode('utf-8')

        # Generate HTML response with embedded image
        return f"""
        <html>
            <body>
                <h1>Random Image</h1>
                <img src="data:image/jpeg;base64,{encoded_image}" alt="Random Image" style="max-width:100%; height:auto;">
            </body>
        </html>
        """, 200, {'Content-Type': 'text/html'}
    except exceptions.GoogleCloudError as e:
        return (f"Google Cloud Error: {str(e)}", 500)
    except Exception as e:
        return (str(e), 500)