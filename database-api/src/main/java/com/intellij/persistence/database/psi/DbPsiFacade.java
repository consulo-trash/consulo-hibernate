package com.intellij.persistence.database.psi;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.ModificationTracker;
import com.intellij.openapi.util.ModificationTrackerListener;
import com.intellij.persistence.database.DataSourceInfo;
import com.intellij.persistence.DatabaseMessages;

/**
 * @author Gregory.Shrago
 */
public abstract class DbPsiFacade implements ModificationTracker{
  public static final String DATABASE_TOOLWINDOW_ID = DatabaseMessages.message("title.toolwindow.database");

  public static DbPsiFacade getInstance(Project project) {
    return ServiceManager.getService(project, DbPsiFacade.class);
  }

  public abstract Project getProject();

  public abstract DbPsiManager[] getDbManagers();

  @Nonnull
  public abstract DbProjectElement getProjectElement();

  @Nonnull
  public abstract DbDataSourceElement[] getDataSources();
  
  @Nullable
  public abstract DbDataSourceElement findDataSource(final String id);

  public abstract void addModificationTrackerListener(final ModificationTrackerListener<DbPsiFacade> listener, final Disposable parent);

  public abstract void removeModificationTrackerListener(final ModificationTrackerListener<DbPsiFacade> listener);

  public abstract DbDataSourceElement createDataSourceWrapperElement(final DataSourceInfo info, final DbPsiManager manager);

  public abstract void clearCaches();
}
