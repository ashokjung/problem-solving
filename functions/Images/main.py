import functions_framework
from google.cloud import storage
from google.cloud import exceptions
import random
import base64

BUCKET_NAME = "gcs-bucket-images"

# Initialize GCS client outside the function for reuse
storage_client = storage.Client()


@functions_framework.http
def hello_http(request):
    try:
        # Fetch blobs from bucket
        blobs = list(storage_client.list_blobs(BUCKET_NAME))
        if not blobs:
            return ("No images found in bucket", 404)

        # Filter for image files only
        image_blobs = [blob for blob in blobs if blob.name.lower().endswith(('.png', '.jpg', '.jpeg', '.gif', '.bmp'))]
        if not image_blobs:
            return ("No image files found in bucket", 404)

        # Select a random image blob
        blob = random.choice(image_blobs)

        # Download the image content
        image_content = blob.download_as_bytes()

        # Encode image content to base64 for embedding
        encoded_image = base64.b64encode(image_content).decode('utf-8')

        # Generate HTML response with embedded image
        return f"""
        <html>
            <body>
                <h1> Funny Images</h1>
                <img src="data:image/jpeg;base64,{encoded_image}" alt="Funny Images" style="max-width:100%; height:auto;">
            </body>
        </html>
        """, 200, {'Content-Type': 'text/html'}
    except exceptions.GoogleCloudError as e:
        return (f"Google Cloud Error: {str(e)}", 500)
    except Exception as e:
        return (str(e), 500)
