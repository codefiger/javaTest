package com.figer.effective.staticfactorymethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by figer on 9/26/16.
 *
 * Noninstantiable class for service registration and access
 */
public class Services {
  private Services(){}// Prevents instantiation

  private static final Map<String, Provider> providers = new ConcurrentHashMap<String, Provider>();

  private static final String DEFUALT_PROVIDER_NAME = "<def>";

  public static void registerProvider(String name, Provider provider){
    providers.put(name, provider);
  }

  public static void registerProvider(Provider provider){
    registerProvider(DEFUALT_PROVIDER_NAME, provider);
  }

  public static Service newInstance(String name){
    Provider provider = providers.get(name);
    if(provider == null){
      throw new IllegalArgumentException(String.format("No provider registered with name:%s", name));
    }
    return provider.newService();
  }

  public static Service newInstance(){
    return newInstance(DEFUALT_PROVIDER_NAME);
  }
}
