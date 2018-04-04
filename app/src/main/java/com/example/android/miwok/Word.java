package com.example.android.miwok;

/**
 * Created by admin on 12/03/2018.
 * The word class represents a vocabulary item the user wants to learn that will be passed into an array
 */

public class Word {

//Word Class fields

    //NO_IMAGE_PROVIDER, holds is initially set ot -1 but is updated with the image resource Id.

    private static final int NO_IMAGE_PROVIDED = -1;

    //mImageResourceId together with NO_IMAGE_ADDED is used to to hold the image resource id.

    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // Default translation for the word

    private String mDefaultTranslation;

    //Miwok translation for the word

    private String mMiwokTranslation;

    private int mAudioResourceId;


//Constructor/s

    /**
     * Create a new Word object that can be called by pages that include an image
     * @param defaultTranslation word in the default language of the user
     * @param miwokTranslation word in the Miwok language
     * @param imageResourceId the resource id for the image
     * @param audioResourceId the resource id for the audio file
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int audioResourceId) {

        mImageResourceId = imageResourceId;
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }

    /**
     * Create a new Word object for activities that don't desplay images
     * @param defaultTranslation word in the default language of the user
     * @param miwokTranslation word in the Miwok language
     * @param audioResourceId the resource id for the audio file
     *
     */

    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId ) {


        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;

    }

//Getter methods

    /**
    *Retrieves the Image resource id from the word object
     * @return mImageResourceId;
     */

    public int getImageResourceId() { return mImageResourceId; }

    /**
     *Retrieves the default translation from the word object
     * @return mDefaultTranslation;
     */

    public String getDefaultTranslation() {
              return mDefaultTranslation;
          }

    /**
     *Retrieves the Miwok translation from the word object
     * @return mMiwokTranslation;
     */

    public String getMiwokTranslation() {
               return mMiwokTranslation;
           }

    /**
     *Retrieves the Audio resource id from the word object
     * @return mAudioResourceId;
     */

    public int getAudioResourceId() {return mAudioResourceId;}

//Methods

    /**
     *Checks if an image resource is present within the word object. if an image is not present the WordAdapter will set the ImageView to: Remove
     * @return true if an image is found;
     */

    public boolean hasImage(){

      return  mImageResourceId != NO_IMAGE_PROVIDED;

    }

}
